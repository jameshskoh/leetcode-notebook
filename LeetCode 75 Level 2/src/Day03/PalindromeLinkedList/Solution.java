package Day03.PalindromeLinkedList;

import java.util.ArrayList;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = getLength(head);
        ListNode currNode = head;

        if (length == 0 || length == 1) {
            return true;
        }

        int half = length / 2;
        ArrayList<Integer> invertedList = new ArrayList<Integer>(half);

        for (int i = half - 1; i >= 0; i--) {
            // we already guaranteed the linked list length, null impossible
            invertedList.add(currNode.val);
            currNode = currNode.next;
        }

        // skip middle one if odd
        if (length % 2 == 1) {
            currNode = currNode.next;
        }

        for (int i = 0; i < half; i++) {
            if (currNode.val != invertedList.get(i)) {
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
}
