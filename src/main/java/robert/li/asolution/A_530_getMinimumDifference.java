package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-24
 */
public class A_530_getMinimumDifference {
    int pre = -1;
    int min =Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(pre != -1) {
            min = Math.min(root.val - pre, min);
        }
        pre = root.val;
        helper(root.right);
    }
}
