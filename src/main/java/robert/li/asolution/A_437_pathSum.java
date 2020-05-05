package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-21
 */
public class A_437_pathSum {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        traversel(root, sum);
        return res;
    }
    void traversel(TreeNode root, int sum) {
        if(root == null) return;
        helper(root, sum);
        traversel(root.left, sum);
        traversel(root.right, sum);
    }

    void helper(TreeNode root, int sum) {
        if(root == null) return ;
        int newSum = sum - root.val;
        if(newSum == 0) {
            res++;
        }
        helper(root.left, newSum);
        helper(root.right, newSum);
    }
}
