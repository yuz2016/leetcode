package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-12
 */
public class B_530_getMinimumDifference {

    int pre = -1;
    int abs = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return abs;
    }

    void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(pre != -1) {
            abs = Math.min(abs, root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }

    void inOrder2(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            // 遍历
            root = pop.right;
        }
    }
}
