package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-16
 */
public class B_226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        if(root.left != null) invertTree(root.left);
        if(root.right != null) invertTree(root.right);
        return root;
    }
}
