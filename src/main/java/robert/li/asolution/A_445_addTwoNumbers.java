package robert.li.asolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-14
 */
public class A_445_addTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        ListNode head7 = new ListNode(4);
        head5.next = head6;
        head6.next = head7;
        A_445_addTwoNumbers a_445_addTwoNumbers = new A_445_addTwoNumbers();
        a_445_addTwoNumbers.addTwoNumbers(head1, head5);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while(r1 != null && r2 != null) {
            int cur = (r1.val + r2.val + carry) % 10;
            carry = (r1.val + r2.val + carry) / 10;
            ListNode listNode = new ListNode(cur);
            listNode.next =  head.next;
            head.next = listNode;
            r1 = r1.next;
            r2 = r2.next;
        }
        ListNode moreNode = r1 == null ? r2 : r1;
        while(moreNode != null) {
            int cur = (moreNode.val + carry) % 10;
            carry = (moreNode.val + carry) / 10;
            ListNode listNode = new ListNode(cur);
            listNode.next =  head.next;
            head.next = listNode;
            moreNode = moreNode.next;
        }
        if(carry != 0) {
            ListNode listNode = new ListNode(carry);
            listNode.next =  head.next;
            head.next = listNode;
        }
        return head.next;
    }

    ListNode reverse(ListNode node) {
        if(node == null) {
            return null;
        }
        ListNode cur = node;
        ListNode next = cur.next;
        ListNode last = null;
        while (next != null) {
            cur.next = last;
            last = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = last;
        return cur;
    }
}
