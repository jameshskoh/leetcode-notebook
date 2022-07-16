Given the `head` of a linked list, remove the `n`th node from the end of the list and return its head.



Follow up: Could you do this in one pass?



Definition of singly-linked list

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```



#### Examples

```
Input: head = [1, 2, 3, 4, 5], n = 2
Output: [1, 2, 3, 5]
```

```
Input: head = [1], n = 1
Output: []
```

```
Input: head = [1, 2], n = 1
Output: [1]
```



#### 1. Questions

* Do I know the size of the linked list directly?
  * No
* Singly or doubly?
  * Singly
* Size: $1 \leq size \leq 30$
* Value: $0 \leq val \leq 100$



#### 2. An Example



#### 3. An Initial Solution

* Go through one pass to find out `length`
* Go through another pass
  * To get the $length - n - 1$th `listNode`
  * To get the $length - n + 1$th `listNode`
    * If null, then null
  * Assign $length - n + 1$th to $length - n - 1$th's next node

* Return `head`

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode currNode = head;
        
        while (currNode.next != null) {
            length++;
            currNode = currNode.next;
        }
        
        // reset reference to head
        currNode = head;
        
        for (int i = 1; i <= length - n; i++) {
            currNode = currNode.next;
        }
        
        ListNode prevNode = currNode;
        ListNode nextNode = prevNode.next.next;
        prevNode.next = nextNode;
        
        return head;
    }
}
```



#### 4. Test The Solution

* Edge cases: **think boundaries**, think **null**
* When the list is 1-long
  * Should return `null`
  * If clause
* When the first node is popped off
  * If clause
* When the last node is popped off
  * The last node can have `.next` which is null
  * Will the prev node have `.next` as null?
    * No: thus `prevNode.next.next` will always work

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode currNode = head;
        
        do {
            length++;
            currNode = currNode.next;
        } while (currNode != null);
        
        if (length == 1) return null;
        else if (length == n) return head.next;
        
        // reset reference to head
        currNode = head;
        
        for (int i = 1; i < length - n; i++) {
            currNode = currNode.next;
        }
        
        ListNode prevNode = currNode;
        ListNode nextNode = prevNode.next.next;
        prevNode.next = nextNode;
        
        return head;
    }
}
```



#### 5. Iterate Through Your Solution

* Could you do this in one pass?
* Edge cases
  * When there is only `head`
    * Return `null` before starting the loop
  * When loop counter `== n`
    * Return `head.next`
    * This will only be known after we have exited the loop
    * Handle this case after the loop
* Set `subhead = head`
* While looping through the list
  * Phase 1: when loop counter `<= n`
    * Do nothing
  * Phase 2: when loop counter `> n`
    * Keep `subhead` `n+1` from the loop end
      * `subhead` should be `prevNode`
    * `subhead = subhead.next`
* Phase 3: when loop ends: `currNode.next == null`
  * `subhead.next = subhead.next.next`

```java
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode subhead = head;
        if (subhead.next == null) {
            return null;
        }

        int count = 1;
        ListNode currNode = head;

        while (currNode.next != null) {
            if (count > n) {
                subhead = subhead.next;
            }

            currNode = currNode.next;
            count++;
        }

        if (count == n) {
            return head.next;
        } else {
            subhead.next = subhead.next.next;
        }

        return head;
    }
}
```

* This method is actually slower




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

