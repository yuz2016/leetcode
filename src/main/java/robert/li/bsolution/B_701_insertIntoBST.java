package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-30
 */
public class B_701_insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
