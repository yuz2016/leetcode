package robert.li.bsolution;



/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-28
 */
public class B_117_connect {
    public Node connect(Node root) {
        Node cur = root;
        while(cur != null) {
            Node dummy = new Node();
            Node tail = dummy;
            while(cur != null) {
                if(cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if(cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }
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
}