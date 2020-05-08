package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-07
 */
public class B_572_isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        boolean sameTree = isSameTree(s, t);
        if(sameTree) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s != null && t == null) {
            return false;
        }
        if(s == null && t != null) {
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
