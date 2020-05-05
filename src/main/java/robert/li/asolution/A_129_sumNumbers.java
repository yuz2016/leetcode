package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-16
 */
public class A_129_sumNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return sum;
    }

    void helper(TreeNode root, int num) {
        int curNum = num * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += curNum;
            return;
        }
        if(root.left != null) {
            helper(root.left, curNum);
        }
        if(root.right != null) {
            helper(root.right, curNum);
        }
    }
}
