package easy;

import common.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode();
        ListNode newlist = dummyhead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newlist.next = list1;
                list1 = list1.next;
            } else {
                newlist.next = list2;
                list2 = list2.next;
            }
            newlist = newlist.next;
        }
        if (list1 != null) {
            newlist.next = list1;

        } else if (list2 != null) {
            newlist.next = list2;

        }
        return dummyhead.next;
    }
}
