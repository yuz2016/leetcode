package robert.li.asolution;

import robert.li.common.ListNode;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-20
 */
public class A_143_reorderList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        A_143_reorderList a_143_reorderList = new A_143_reorderList();
        a_143_reorderList.reorderList(node1);
    }

    public void reorderList(ListNode head) {
        if(head == null) return;
        // 后半部分逆序链表
        ListNode b = reverseLastHalf(head);
        // 两部分链表合并
        merge(head, b);
    }

    ListNode reverseLastHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode dummy = new ListNode(-1);
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    void merge(ListNode a, ListNode b) {
        int i = 0;
        ListNode cur = a;
        while(a != null && b != null) {
            if(i % 2 == 0) {
                a = a.next;
                cur.next = b;
            } else {
                b = b.next;
                cur.next = a;
            }
            cur = cur.next;
            i++;
        }
    }
}
