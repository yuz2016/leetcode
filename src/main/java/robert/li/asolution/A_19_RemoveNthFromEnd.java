package robert.li.asolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/22
 */
public class A_19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, cur = head;
        int i = 0;
        while(i < n && cur.next != null){
            cur = cur.next;
            i++;
        }
        // n即链表长度
        if(cur.next == null && i != n){
            return head.next;
        }

        while(cur.next!=null){
            cur = cur.next;
            pre = pre.next;
        }

        pre.next= pre.next.next;
        return head;
    }
}
