package robert.li.asolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-21
 */
public class A_148_sortList {
    public ListNode sortList(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null)
            return head;
        // 找中点，奇数个是中间点，偶数个是中位左边的点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分割
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        // 合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
