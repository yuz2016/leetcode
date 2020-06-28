package robert.li.asolution;

import robert.li.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class M_0201_removeDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode last = null;
        ListNode cur = head;
        while(cur != null) {
            if(last != null && set.contains(cur.val)) {
                last.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                last = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
