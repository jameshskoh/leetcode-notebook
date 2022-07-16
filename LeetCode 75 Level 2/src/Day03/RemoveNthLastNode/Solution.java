package Day03.RemoveNthLastNode;

public class Solution {
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
