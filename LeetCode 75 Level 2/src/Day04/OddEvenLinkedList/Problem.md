Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.



The first node is considered odd, and the second node is considered even, and so on.



Note that the relative order inside both the even and odd groups should remain as it was in the input.



You must solve the problem in `O(1)` extra space complexity and `O(n)` time complexity.



#### Examples

```
Input: head = [1, 2, 3, 4, 5]
Output: [1, 3, 5, 2, 4]
```

```
Input: head = [2, 1, 3, 5, 6, 4, 7]
Output: [2, 3, 6, 7, 1, 5, 4]
```



#### 1. Questions

* Does the linked list contain only integers?
  * Yes: $-10^6 \leq val \leq 10^6$

* How long is the linked list?
  * $0 \leq size \leq 10^4$
  * Could be length 0
  * Could be length 1
  * Could be odd or even length

* Odd starts first, the "index" starts with 1



#### 2. An Example

```
Input: head = []
Output: []
```

```
Input: head = [1]
Output: [1]
```

```
Input: head = [1, 2]
Output: [1, 2]
```



#### 3. An Initial Solution

* If `head == null`
  * Return `null`
* Create `evenHead = head.next`
  * Used to join to the end of odd sublist
  * If `evenHead == null` return `head`
* Create `currOdd = head`
* Create `currEven = evenHead`
* Create `bool insertMode = true`
  * True: odd
  * False: even
* Create `currNode = currEven.next`
* While `currNode != null`
  * If `insertMode`
    * `currOdd.next = currNode`
    * `currOdd = currNode`
  * Else
    * `currEven.next = currNode`
    * `currEven = currNode`
  * `currNode = currNode.next`
  * Invert `insertMode`

* `currOdd.next = evenHead`
* Return `head`

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenHead = head.next;
        if (evenHead == null) return head;
        
        ListNode currOdd = head;
        ListNode currEven = evenHead;
        
        boolean insertMode = true;
        ListNode currNode = currEven.next;
        
        while (currNode != null) {
            if (insertMode) {
                currOdd.next = currNode;
                currOdd = currNode;
            } else {
                currEven.next = currNode;
                currEven = currNode;
            }
            
            currNode = currNode.next;
        }
        
        currOdd.next = evenHead;
        
        return head;
    }
}
```



#### 4. Test The Solution

* Bug: loop in `ListNode`
  * While `currOdd.next` has to set to `evenHead`
  * What about `currEven.next`?
    * It has to be set to `null`!
    * Else it will be pointing to the odd sublist again
* Forgot to alter `insertMode` in loop
  * Added

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenHead = head.next;
        if (evenHead == null) return head;
        
        ListNode currOdd = head;
        ListNode currEven = evenHead;
        
        boolean insertMode = true;
        ListNode currNode = evenHead.next;
        
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            
            if (insertMode) {
                currOdd.next = currNode;
                currOdd = currNode;
                insertMode = false;
            } else {
                currEven.next = currNode;
                currEven = currNode;
                insertMode = true;
            }
            
            currNode = nextNode;
        }
        
        currOdd.next = evenHead;
        currEven.next = null;
        
        return head;
    }
}
```



#### 5. Iterate Through Your Solution




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

