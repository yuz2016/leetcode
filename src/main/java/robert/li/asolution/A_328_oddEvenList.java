package robert.li.asolution;

import robert.li.common.ListNode;

public class A_328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddTmp = odd;
        ListNode evenTmp = even;
        ListNode tmp = even.next;
        int i = 1;
        while(tmp != null) {
            if(i % 2 == 1) {
                oddTmp.next = tmp;
                oddTmp = oddTmp.next;
                tmp = tmp.next;
            } else {
                evenTmp.next = tmp;
                evenTmp = evenTmp.next;
                tmp = tmp.next;
            }
            i++;
        }
        evenTmp.next = null;
        oddTmp.next = even;
        return odd;
    }
}
