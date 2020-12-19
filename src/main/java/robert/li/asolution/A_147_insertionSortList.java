package robert.li.asolution;

import robert.li.common.ListNode;

public class A_147_insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head.next;
        head.next = null;
        while(cur != null) {
            ListNode next = cur.next;
            insert(dummy, cur);
            cur = next;
        }
        return dummy.next;
    }

    void insert(ListNode dummy, ListNode insert) {
        ListNode cur = dummy;
        while(cur.next != null && cur.next.val < insert.val) {
            cur = cur.next;
        }
        insert.next = cur.next;
        cur.next = insert;
    }
}
