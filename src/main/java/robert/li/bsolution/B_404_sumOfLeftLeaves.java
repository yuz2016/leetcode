package robert.li.bsolution;

import robert.li.common.TreeNode;

public class B_404_sumOfLeftLeaves {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root, false);
        return res;
    }

    void preOrder(TreeNode root, boolean isLeft) {
        if(root == null) return;
        if(root.left == null && root.right == null && isLeft) {
            res+=root.val;
            return;
        }
        preOrder(root.left, true);
        preOrder(root.right, false);
    }
}
