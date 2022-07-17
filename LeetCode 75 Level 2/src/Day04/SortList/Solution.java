package Day04.SortList;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;

        ListNode middle = getMiddle(head, null);
        ListNode sortedFront = recurse(head, middle);
        ListNode sortedMiddle = recurse(middle, null);

        return merge(sortedFront, middle, sortedMiddle, null);
    }

    private ListNode recurse(ListNode front, ListNode end) {
        if (front.next == end) return front;

        ListNode middle = getMiddle(front, end);

        ListNode sortedFront = recurse(front, middle);
        ListNode sortedMiddle = recurse(middle, end);

        return merge(sortedFront, middle, sortedMiddle, end);
    }

    private ListNode merge(ListNode sortedFront, ListNode middle, ListNode sortedMiddle, ListNode end) {
        ListNode curr1 = sortedFront;
        ListNode curr2 = sortedMiddle;

        ListNode curr = null;
        ListNode head = null;

        if (curr1.val <= curr2.val) {
            head = curr1;
            curr = curr1;
            curr1 = curr1.next;
        } else {
            head = curr2;
            curr = curr2;
            curr2 = curr2.next;
        }

        while (curr1 != middle && curr2 != end) {
            if (curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            }
        }

        if (curr1 == middle) {
            curr.next = curr2;
        } else if (curr2 == end) {
            curr.next = curr1;

            while (curr.next != middle) {
                curr = curr.next;
            }

            curr.next = end;
        }

        return head;
    }

    private ListNode getMiddle(ListNode myHead, ListNode end) {
        ListNode fast = myHead;
        ListNode slow = myHead;

        while (true) {
            if (fast == end || fast.next == end) {
                return slow;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
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
        Solution s = new Solution();

        ListNode head = new ListNode(5);
        ListNode currNode = head;
        currNode.next = new ListNode(2);
        currNode = currNode.next;
        currNode.next = new ListNode(7);
        currNode = currNode.next;
        currNode.next = new ListNode(3);
        currNode = currNode.next;
        currNode.next = new ListNode(4);
        currNode = currNode.next;
        currNode.next = new ListNode(1);
        currNode = currNode.next;
        currNode.next = new ListNode(6);
        currNode = currNode.next;

        ListNode test = s.sortList(head);
        s.printListNode(test);
    }
}
