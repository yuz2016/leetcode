package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-26
 */
public class A_606_tree2str {
    public String tree2str(TreeNode t) {
        // 递归终止条件
        if (t == null)
            return "";
        // 情况1
        if (t.left == null && t.right == null)
            return t.val + "";
        // 情况2
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        // 情况3和4
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
