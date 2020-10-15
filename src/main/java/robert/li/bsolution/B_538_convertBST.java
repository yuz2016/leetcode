package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-21
 */
public class B_538_convertBST {

    int tmp = 0;

    public TreeNode convertBST(TreeNode root) {
        reverseMidOrder(root);
        return root;
    }

    void reverseMidOrder(TreeNode root) {
        if(root == null) return;
        reverseMidOrder(root.right);
        tmp = root.val = tmp + root.val;
        reverseMidOrder(root.left);
    }
}
