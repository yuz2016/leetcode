package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-28
 */
public class B_104_maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 0;
        int right = 0;
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
