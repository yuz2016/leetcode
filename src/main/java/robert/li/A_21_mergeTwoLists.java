package robert.li;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/24
 */
public class A_21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode head = l1;
        ListNode cur = head;
        l1 = l1.next;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return head;
    }
}
