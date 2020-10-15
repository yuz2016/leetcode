package robert.li.asolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-13
 */
public class A_24_swapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = cur.next;
        while(true) {
            pre.next = next;
            next = next.next;
            pre.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = pre.next;
            if(cur == null || cur.next == null) break;
            next = cur.next;
        }
        return dummy.next;
    }
}
