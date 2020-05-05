package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-25
 */
public class A_563_findTilt {
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    // 返回包含当前节点的之和
    int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int cur = Math.abs(left - right);
        sum += cur;
        return root.val + left + right;
    }
}
