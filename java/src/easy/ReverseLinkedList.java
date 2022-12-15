package easy;

import common.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
