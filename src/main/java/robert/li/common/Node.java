package robert.li.common;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-25
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
