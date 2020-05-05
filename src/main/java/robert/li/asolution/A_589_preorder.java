package robert.li.asolution;

import robert.li.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-26
 */
public class A_589_preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            list.add(pop.val);
            for (int i = pop.children.size() - 1; i >= 0; i--) {
                stack.add(pop.children.get(i));
            }
        }
        return list;
    }
}
