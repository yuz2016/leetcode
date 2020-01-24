package robert.li;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-23
 */
public class A_513_findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(i == 0) {
                    res = poll.val;
                }
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null)queue.add(poll.right);
            }
        }
        return res;
    }

    int maxDepth = -1, res = -1;
    // 递归
    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) return;
        helper(root.left, depth + 1);
        //判断是否是最大深度
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        helper(root.right, depth + 1);
    }
}
