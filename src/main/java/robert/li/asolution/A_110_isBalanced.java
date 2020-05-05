package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-15
 */
public class A_110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int x = Math.abs(higher(root.left) - higher(root.right));
        if(x > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int higher(TreeNode root) {
        if(root == null) return 0;
        return Math.max(higher(root.left),higher(root.right)) + 1;
    }

    /**
     * 提前阻断法
     *
     * 深度优先遍历 当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
