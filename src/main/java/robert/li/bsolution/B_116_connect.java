package robert.li.bsolution;

public class B_116_connect {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Node dummy = new Node(-1);
        dummy.next = root;
        while(dummy.next.left != null) {
            Node cur = dummy.next;
            Node pre = dummy;
            while(cur != null) {
                pre.next = cur.left;
                cur.left.next = cur.right;
                pre = pre.next.next;
                cur = cur.next;
            }
        }
        return root;
    }
}
