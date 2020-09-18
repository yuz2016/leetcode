package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class B_637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            double cur = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
                cur += poll.val;
            }
            res.add(cur / size);
        }
        return res;
    }
}
