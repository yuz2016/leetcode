package robert.li;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-24
 */
public class A_538_convertBST {
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    void helper(TreeNode root) {
        if(root == null) return;
        helper(root.right);
        if(pre == null) {
            pre = root;
        } else {
            root.val = root.val + pre.val;
            pre = root;
        }
        helper(root.left);
    }
}
