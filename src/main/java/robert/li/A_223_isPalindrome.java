package robert.li;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/24
 */
public class A_223_isPalindrome {

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast!= null) {//偶数
            slow = slow.next;
        }

        ListNode listNode = reverseList(slow);
        while (head!=null && listNode!=null) {
            if (head.val != listNode.val) {
                return false;
            }
            head = head.next;
            listNode = listNode.next;
        }
        return true;

    }

    ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
