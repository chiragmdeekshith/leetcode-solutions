package easy;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    // HashTable implementation, O(n) speed, O(n) space
    public boolean hasCycle1(ListNode head) {
        ListNode current = head;
        Set set = new HashSet();
        while(current != null){
            if(set.contains(current.hashCode())){
                return true;
            }
            set.add(current.hashCode());
            current = current.next;
        }
        return false;
    }

    // two pointers, O(1) space
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
