package robert.li;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-25
 */
public class A_572_isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSameTree(s, t)) return true;
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        return left || right;
    }

    // 判断两颗树是否相同
    boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.val != t.val) return false;
        boolean left = isSameTree(s.left, t.left);
        boolean right = isSameTree(s.right, t.right);
        return  left && right;
    }
}
