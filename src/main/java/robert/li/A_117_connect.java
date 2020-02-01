package robert.li;



/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-16
 */
public class A_117_connect {
    Node connect(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node tail = dummy;
            //遍历 cur 的当前层
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            //更新 cur 到下一层
            cur = dummy.next;
        }
        return root;
    }
}
