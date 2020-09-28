package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-27
 */
public class B_235_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val) {
            return helper(root, p, q);
        } else {
            return helper(root, q, p);
        }
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        if(root.val > p.val && root.val < q.val) {
            return root;
        }
        if(root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
