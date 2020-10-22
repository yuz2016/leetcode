package robert.li.bsolution;

import robert.li.common.ListNode;

public class B_19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode sec = dummy;
        int i = 0;
        while(i < n - 1) {
            first = first.next;
            i++;
        }
        while(first != null && first.next != null) {
            first = first.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return dummy.next;
    }
}
