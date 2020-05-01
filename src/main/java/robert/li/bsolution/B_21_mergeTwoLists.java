package robert.li.bsolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-01
 */
public class B_21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode next = null;
        if(l1.val <= l2.val) {
            head.next = l1;
            l1 = l1.next;
        } else {
            head.next = l2;
            l2 = l2.next;
        }
        next = head.next;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                next.next = l1;
                next = next.next;
                l1 = l1.next;
            } else {
                next.next = l2;
                next = next.next;
                l2 = l2.next;
            }
        }
        l1 = l1 == null ? l2 : l1;
        while(l1 != null) {
            next.next = l1;
            next = next.next;
            l1 = l1.next;
        }
        return head.next;
    }
}
