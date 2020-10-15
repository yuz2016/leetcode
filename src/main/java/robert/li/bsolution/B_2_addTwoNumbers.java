package robert.li.bsolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-04
 */
public class B_2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode curNode = root;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            curNode.next = new ListNode(cur);
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 处理链表长度不同
        ListNode node = l1 == null ? l2 : l1;
        while(node != null) {
            int sum = node.val + carry;
            int cur = sum % 10;
            carry = sum / 10;
            curNode.next = new ListNode(cur);
            curNode = curNode.next;
            node = node.next;
        }
        // 处理最后的进位
        if(carry != 0) {
            curNode.next = new ListNode(carry);
        }
        return root.next;
    }
}
