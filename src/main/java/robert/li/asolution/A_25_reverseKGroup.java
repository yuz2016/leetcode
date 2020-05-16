package robert.li.asolution;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-16
 */
public class A_25_reverseKGroup {
    public static void main(String[] args) {
        A_25_reverseKGroup a_25_reverseKGroup = new A_25_reverseKGroup();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = a_25_reverseKGroup.reverseKGroup(listNode1, 2);
        System.out.println(1);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = length(head);
        if(k == 1 || length <= 1) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        ListNode tail = head;
        int i = 0;
        int count = length / k;
        int c = 0;
        while(i < k) {
            i++;
            next = cur.next;
            cur.next = pre;
            if(i == k) {
                i = 0;
                c++;
                pre = null;
                head = cur;
                cur = next;
                break;
            }
            pre = cur;
            cur = next;
        }
        ListNode curTail = null;
        pre = null;
        while(i < k && cur != null && c < count) {
            i++;
            if(i == 1) {
                curTail = cur;
            }
            next = cur.next;
            cur.next = pre;
            if(i == k) {
                i = 0;
                c++;
                tail.next = cur;
                tail = curTail;
            }
            pre = cur;
            cur = next;
        }
        tail.next = cur;
        return head;
    }

    int length(ListNode listNode) {
        int i = 0;
        while(listNode != null) {
            listNode = listNode.next;
            i++;
        }
        return i;
    }
}
