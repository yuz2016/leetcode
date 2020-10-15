package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-21
 */
public class C_144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right != null) stack.push(pop.right);
            if(pop.left != null) stack.push(pop.left);
        }
        return res;
    }
}
