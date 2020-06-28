package robert.li.bsolution;

import robert.li.common.TreeNode;

public class B_124_maxPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }


    /**
     * 返回以当前节点root开始的最长路径 可能正 可能负
     *
     * @param root
     * @return
     */
    int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        int tmp = root.val;
        if(left > 0) {
            tmp += left;
        }
        if(right > 0) {
            tmp += right;
        }
        res = Math.max(res, tmp);

        int max = Math.max(left, right);
        return max > 0 ? max + root.val : root.val;
    }
}
