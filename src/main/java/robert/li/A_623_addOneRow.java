package robert.li;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-28
 */
public class A_623_addOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        // 寻找d-1层节点
        int level = 1;
        while(level < d - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
            }
            level++;
        }

        // d层 增加v
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if(poll.left != null) {
                TreeNode node = new TreeNode(v);
                node.left = poll.left;
                poll.left = node;
            } else {
                TreeNode node = new TreeNode(v);
                poll.left = node;
            }

            if(poll.right != null) {
                TreeNode node = new TreeNode(v);
                node.right = poll.right;
                poll.right = node;
            } else {
                TreeNode node = new TreeNode(v);
                poll.right = node;
            }
        }
        return root;
    }
}
