package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-05
 */
public class B_98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer left, Integer right) {
        if(root == null) return true;
        if(root.left != null && root.left.val > root.val) {
            return false;
        }
        if(left != null && left > root.val) {
            return false;
        }
        if(root.right != null && root.right.val < root.val) {
            return false;
        }
        if(right != null && right < root.val) {
            return false;
        }
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }


}
