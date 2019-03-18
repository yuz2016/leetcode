package robert.li;

import robert.li.common.ListNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/27
 */
public class A_237_DeleteNode {
    private ListNode head;

    public static void main(String[] args) {

    }

    /**
     * 链表至少包含两个节点
     * 删除头节点，头节点next为空
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
