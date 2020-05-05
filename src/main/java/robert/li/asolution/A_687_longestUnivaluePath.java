package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-01
 */
public class A_687_longestUnivaluePath {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }

    int helper(TreeNode root) {
        if(root == null) return 0;
        int l = 0, r = 0;
        int left = helper(root.left);
        if(root.left != null && root.val == root.left.val) {
            l = 1 + left;
        }
        int right = helper(root.right);
        if(root.right != null && root.val == root.right.val) {
            r = 1 + right;
        }
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
