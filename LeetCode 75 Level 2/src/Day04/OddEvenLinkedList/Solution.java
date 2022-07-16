package Day04.OddEvenLinkedList;

public class Solution {
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