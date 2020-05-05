package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-20
 */
public class A_335_rob {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int doIt = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int notDoIt = rob(root.left) + rob(root.right);
        int max = Math.max(doIt, notDoIt);
        map.put(root, max);
        return max;
    }
}
