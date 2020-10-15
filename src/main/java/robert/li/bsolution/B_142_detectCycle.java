package robert.li.bsolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-10
 */
public class B_142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
