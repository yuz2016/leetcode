package robert.li;

import robert.li.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-26
 */
public class A_23_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n < 1)
            return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(n, Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
        }
        return head.next;
    }
}
