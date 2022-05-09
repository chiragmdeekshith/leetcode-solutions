package medium;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();
        int sum;
        int carry = 0;
        for (ListNode temp = l3; l1 != null || l2 != null || carry > 0; temp = temp.next) {
            if (l1 == null && l2 == null && carry > 0){
                sum = carry;
            }
            else if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry = 0;
            }
            temp.next = new ListNode(sum);
        }

        return l3.next;
    }
}