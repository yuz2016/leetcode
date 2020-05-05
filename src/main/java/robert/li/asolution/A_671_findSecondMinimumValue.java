package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-01
 */
public class A_671_findSecondMinimumValue {
    int first = -1, sec = -1;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return sec;
    }

    void helper(TreeNode root) {
        if(root == null) return;
        if(first == -1) first = root.val;
        if(first != -1 && first != root.val && sec == -1) {
            sec = root.val;
            return;
        }
        if(first != -1 && first != root.val && sec != -1) {
            sec = Math.min(sec, root.val);
            return;
        }
        helper(root.left);
        helper(root.right);
    }
}
