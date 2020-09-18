package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-14
 */
public class B_144_preorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = stack.pop();
        }
        return res;
    }


}
