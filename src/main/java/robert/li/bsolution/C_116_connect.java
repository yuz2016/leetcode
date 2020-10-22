package robert.li.bsolution;

public class C_116_connect {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Node dummy = new Node(-1);
        dummy.next = root;
        boolean b = true;
        while(b) {
            Node cur = dummy.next;
            Node pre = dummy;
            b = false;
            while(cur != null) {
                if(cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                    b = true;
                }
                if(cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                    b = true;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
