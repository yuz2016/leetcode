package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-24
 */
public class A_543_diameterOfBinaryTree {
    int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxLength;
    }

    int helper(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        if(root.left != null && root.right == null) {
            int cur = helper(root.left) + 1;
            maxLength = Math.max(maxLength, cur);
            return cur;
        }
        if(root.right != null && root.left == null) {
            int cur = helper(root.right) + 1;
            maxLength = Math.max(maxLength, cur);
            return cur;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        maxLength = Math.max(maxLength, left + right + 2);
        return Math.max(left, right) + 1;
    }
}
