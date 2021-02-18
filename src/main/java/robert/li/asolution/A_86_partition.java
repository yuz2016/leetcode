package robert.li.asolution;

import robert.li.common.ListNode;

public class A_86_partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode res = new ListNode(-1);
        ListNode low = res;
        ListNode cur = head;
        ListNode pre = dummy;
        while(cur != null) {
            if(cur.val < x) {
                pre.next = cur.next;
                cur.next = null;
                low.next = cur;
                low = low.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        low.next = dummy.next;
        return res.next;
    }
}
