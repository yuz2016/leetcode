package robert.li.asolution;

import robert.li.common.TreeNode;

public class A_337_rob {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int rob = root.val + (root.left == null ? 0 : (rob(root.left.left)
                + rob(root.left.right))) + (root.right == null ? 0 : (rob(root.right.left)
                + rob(root.right.right)));
        int no_rob = rob(root.left) + rob(root.right);
        return Math.max(rob, no_rob);
    }
}
