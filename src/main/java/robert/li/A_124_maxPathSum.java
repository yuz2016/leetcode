package robert.li;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-16
 */
public class A_124_maxPathSum {
    int res = Integer.MIN_VALUE;
    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    int helper(TreeNode root) {
        if(root.left == null && root.right == null) {
            res = Math.max(res, root.val);
            return root.val;
        }
        if(root.left != null && root.right == null) {
            int left = helper(root.left);
            res = Math.max(res, left + root.val);
            res = Math.max(res, root.val);
            if(left < 0) {
                return root.val;
            }
            return left + root.val;
        }

        if(root.left == null && root.right != null) {
            int right = helper(root.right);
            res = Math.max(res, right + root.val);
            res = Math.max(res, root.val);
            if(right < 0) {
                return root.val;
            }
            return right + root.val;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + root.val);
        res = Math.max(res, right + root.val);
        res = Math.max(res, left + right + root.val);
        res = Math.max(res, root.val);
        return Math.max(Math.max(left + root.val, right + root.val), root.val);
    }

    /**
     * 计算包含这个顶点的最大权值路径。
     *
     * @param node
     * @return
     */
    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }
}
