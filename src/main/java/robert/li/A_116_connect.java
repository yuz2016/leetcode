package robert.li;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-16
 */
public class A_116_connect {

    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
                if(pre != null) {
                    pre.next = poll;
                }
                pre = poll;
            }
            pre = null;
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}


