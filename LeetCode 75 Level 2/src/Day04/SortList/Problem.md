Given the `head` of a linked list, return the list after sorting it in ascending order.



#### Examples

```
Input: head = [4, 2, 1, 3]
Output: [1, 2, 3, 4]
```

```
Input head = [-1, 5, 3, 4, 0]
Output: [-1, 0, 3, 4, 5]
```

```
Input head = []
Output: []
```



Follow up: Can you sort the linked list in `O(n log n)` time and `O(1)` space?



#### 1. Questions

* The number of nodes?
  * $0 \leq num \leq 10^4$
* Are they integers?
  * Yes: $-10^5 \leq val \leq 10^5$



#### 2. An Example



#### 3. An Initial Solution

* Use quick sort
  * Tailored to linked list

```pseudocode
FUNCTION quickSort(ListNode head) RETURN ListNode head:
	SET ListNode pivot = head
	
	SET ListNode temp = CALL pivotSort WITH null, null, pivot
	
	IF temp == null
		RETURN head
	ELSE
		RETURN temp

FUNCTION pivotSort(ListNode start, ListNode end, ListNode pivot) RETURN void:
	// base case
	IF pivot.next == end
		RETURN pivot
    END IF
	
	SET ListNode currLeft = pivot
	SET ListNode currRight = pivot
	SET ListNode curr = pivot.next
	
	// if ever get reassigned, then head is changed
	// will be returned so that the caller knows head is changed
	SET currHead = null
	
	WHILE curr != end
		SET ListNode next = curr.next
		IF curr.val < pivot.val
			// put before
			
			// let currRight skip curr
			currRight.next = curr.next
			
			// let curr point to currLeft
			curr.next = currLeft
			IF start == null
				// the head portion of the list, replace the head
				currHead = curr
            ELSE
            	// not the head portion of the list
            	start.next = curr
			END IF
			
			currLeft = curr
		ELSE
			// put after
			
			currRight = curr
		END IF
		
		curr = next
	END WHILE
	
	IF currLeft != pivot
		// left part is not empty
		SET ListNode temp = CALL pivotSort WITH start, pivot, currLeft
		IF temp != null
			// subsequent sort reordered the head
			currHead = temp
		END IF
	END IF
	
	IF currRight != pivot
		// right part is not empty
		// right part is never going to change the head
		CALL pivotSort WITH pivot, end, pivot.next
	END IF
	
	RETURN currHead;

```



#### 4. Test The Solution

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        
        ListNode pivot = head;
        
        ListNode temp = pivotSort(null, null, pivot);
        
        if (temp == null) {
            return head;
        } else {
            return temp;
        }
    }
    
    private ListNode pivotSort(ListNode start, ListNode end, ListNode pivot) {
        if (pivot.next == end) return pivot;
        
        ListNode currLeft = pivot;
        ListNode currRight = pivot;
        ListNode curr = pivot.next;
        
        ListNode currHead = null;
        
        while (curr != end) {
            ListNode next = curr.next;
            
            if (curr.val < pivot.val) {
                currRight.next = curr.next;
                
                curr.next = currLeft;
                
                if (start == null) {
                    currHead = curr;
                } else {
                    start.next = curr;
                }
                
                currLeft = curr;
            } else {
                currRight = curr;
            }
            
            curr = next;
        }
        
        if (currLeft != pivot) {
            ListNode temp = pivotSort(start, pivot, currLeft);
            
            if (temp != null) {
                currHead = temp;
            }
        }
        
        if (currRight != pivot) {
            pivotSort(pivot, end, pivot.next);
        }
        
        return currHead;
    }
}
```



#### 5. Iterate Through Your Solution

* The above solution timed out in LeetCode
* Analysis
  * Not stable
  * Highly dependent on the content of the linked list
    * Worst case: $O(n^2)$
    * When the list is sorted in the wrong order
    * When the list has a lot of equal values
  * Quick sort is particularly slower in linked list
* Merge sort would be better
  * Worst case: $O(n \log n)$
  * Not dependent on the content of the linked list
  * Better suited for linked list

```pseudocode
FUNCTION mergeSort(ListNode head) RETURN ListNode head:
	SET ListNode middle = CALL getMiddle WITH head
	
	SET ListNode sortedFront = CALL recurse WITH head, middle
	SET ListNode sortedMiddle = CALL recurse WITH middle, null
	
	RETURN CALL merge WITH sortedFront, sortedMiddle

FUNCTION recurse(ListNode front, ListNode end) ListNode sorted:
	// base case
	IF front.next == end
		RETURN front
	END IF
	
	SET ListNode middle = CALL getMiddle WITH head, end
	
	SET ListNode sortedFront = CALL recurse WITH front, middle
	SET ListNode sortedMiddle = CALL recurse with middle, end
	
	RETURN CALL merge WITH sortedFront, middle, sortedMiddle, end

FUNCTION merge(ListNode sortedFront, ListNode middle, ListNode sortedMiddle, ListNode end) RETURN ListNode sortedFront:
	SET ListNode curr1 = sortedFront
	SET ListNode curr2 = sortedMiddle
	
	SET ListNode curr = null
	SET ListNode head = null
	
	IF curr1.val <= curr2.val
		head = curr1
		curr = curr1
		curr1 = curr1.next
    ELSE
    	head = curr2
    	curr = curr2
    	curr2 = curr2.next
    END IF
	
	WHILE (curr1 != middle OR curr2 != end)
		IF curr1.val <= curr2.val
			curr.next = curr1
			curr1 = curr1.next
		ELSE
			curr.next = curr2
			curr2 = curr2.next
		END IF
	END WHILE
	
	IF curr1 == middle
		curr.next = curr2
		// nothing to do, since it ends with end
    ELSE IF curr2 == end
    	curr.next = curr1
    
        // set last.next = end, so that the list can be merged by the a higher level merge
        WHILE curr.next != middle
        curr = curr.next
        END WHILE

        curr.next = end
        END IF
    END IF
    
    RETURN head
	
FUNCTION getMiddle(ListNode myHead, ListNode end) RETURN ListNode middle:
	SET ListNode fast = myHead
	SET ListNode slow = myHead
	
	WHILE true
		IF fast.next == end
			RETURN slow
        END IF
        
        fast = fast.next
        
        IF fast.next == end
        	RETURN slow
      	END IF
      	
      	fast = fast.next
      	slow = slow.next
	END WHILE
```

* This is hard to implement
  * How to make it easier to solve?
* This uses $O(\log n)$ space
  * Due to the holding stack
  * Solve this iteratively, one at a time, then you can get $O(1)$ space
    * Bottom-up merge sort
* This approach kept track of the starting points and ending points of the linked list
  * You could unlink the linked list
  * Since you still can keep track of the order of the linked list via `merge`
  * You can unlink the linked list when doing `getMiddle`




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

