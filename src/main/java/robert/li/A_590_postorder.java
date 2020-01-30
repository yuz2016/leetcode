package robert.li;

import robert.li.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-26
 */
public class A_590_postorder {
    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        stack.add(root);
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            res.addFirst(pop.val);
            for (int i = 0; i < pop.children.size(); i++) {
                stack.push(pop.children.get(i));
            }
        }
        return res;
    }
}
