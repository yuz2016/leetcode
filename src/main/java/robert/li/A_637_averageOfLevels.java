package robert.li;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-28
 */
public class A_637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
            }
            Double d = sum * 1.0 / size;
            list.add(d);
        }
        return list;
    }
}
