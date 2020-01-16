package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-15
 */
public class A_111_minDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        if(root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
