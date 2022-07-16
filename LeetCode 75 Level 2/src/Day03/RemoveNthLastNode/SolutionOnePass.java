package Day03.RemoveNthLastNode;

public class SolutionOnePass {
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

    private void printListNode(ListNode head) {
        ListNode currNode = head;
        System.out.println("Start: ");
        while (currNode != null) {
            System.out.print(currNode.val + " > ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SolutionOnePass s = new SolutionOnePass();

        ListNode head = new ListNode(1);
        ListNode currNode = head;
        currNode.next = new ListNode(2);
        currNode = currNode.next;

        System.out.println("Original");
        s.printListNode(head);

        System.out.println("New");
        s.printListNode(s.removeNthFromEnd(head, 2));
    }
}
