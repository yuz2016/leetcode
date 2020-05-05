package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-28
 */
public class A_617_mergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        TreeNode root;
        if(t1 == null || t2 == null) {
            TreeNode tmp = t1 == null ? t2 : t1;
            root = new TreeNode(tmp.val);
            root.left = mergeTrees(tmp.left, null);
            root.right = mergeTrees(tmp.right, null);
        } else {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}
