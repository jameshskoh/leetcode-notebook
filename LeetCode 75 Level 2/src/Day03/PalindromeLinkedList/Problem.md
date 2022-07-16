Given the `head` of a singly linked list, return `true` if it is a palindrome.



Follow up: Could you do it in `O(n)` time and `O(1)` space?



Definition for singly-linked list

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```



#### Example 1

```
Input: head = [1, 2, 2, 1]
Output: true
```

```
Input: head = [1, 2]
Output: false
```



#### 1. Questions

* The linked list stores integer only?
  * Yes, and is 0-9
  * $0 \leq Node.val \leq 9$
* Number of nodes in the list?
  * $1 \leq n \leq 100000$



#### 2. An Example

```
Input: head = [1]
Output: true
```

```
Input: head = [1, 2, 1]
Output: true
```

```
Input: head = [1, 1]
Output: true
```

```
Input: head = [1, 1, 1]
Output: true
```



#### 3. An Initial Solution

* Find the length of the linked list
* Loop through the first half of the linked list
  * Create the `inverted` of the first half of the linked list, you can use `int[]`, and you already know its size
  * Define `half`
    * Even length: `length / 2`
    * Odd length: `length / 2`
      * The middle one does not need to be checked
  * Note: use `ArrayList`? Not possible, as you want to populate data from the end of `inverted`
    * `ArrayList` append to front would not be $O(1)$
* Now the linked list is looped to the middle
  * Odd? Skip one
  * Even? Continue
* For each value in `inverted`
  * If any of them does not match the rest of the linked list
    * Return `false`
* End of for loop
  * Return `true`
* Linear time
* Linear space

```java
public boolean isPalindrome(ListNode head) {
    int length = getLength(head);
    ListNode currNode = head;
    
    if (length == 1) {
        return true;
    }
    
    int half = length / 2;
    int[] invertedList = new int[half];
    
    for (int i = half - 1; i >= 0; i--) {
        // we already guaranteed the linked list length, null impossible
        invertedList[i] = currNode.val;
        currNode = currNode.next;
    }
    
    // skip middle one if odd
    if (length % 2 == 1) {
        currNode = currNode.next;
    }
    
    for (int i = 0; i < half; i++) {
        if (currNode.val != invertedList[i]) {
            return false;
        }
        
        currNode = currNode.next;
    }
    
    return true;
}

private int getLength(ListNode head) {
    int count = 0;
    while (head != null) {
        count++;
        head = head.next;
    }
    
    return count;
}
```



#### 4. Test The Solution



#### 5. Iterate Through Your Solution

* Could you do it in `O(n)` time and `O(1)` space?
  * Invert the second half of the linked list
  * You only need a constant amount of references to invert the second half of the linked list and reconstruct it
    * Linear time
    * Constant space
  * Keep reference of `head`, `secondHalfHead`
    * Start comparing them till the end
    * Linear time
  * You may need to invert the linked list back

* Thus a linear time constant space algorithm




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

