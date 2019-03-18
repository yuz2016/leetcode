package robert.li;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/24
 */
public class A_206_reverseList {
    /**
     * 1 -> 2 -> 3 -> null  null <- 1 <- 2 <- 3
     * iterate
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    /**
     * n1 -> ... -> nk -> nk+1 <- nk+2 ... <- nm
     * Recursive
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
