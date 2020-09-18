package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class B_107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                curList.add(poll.val);
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
            list.add(0, curList);
        }
        return list;
    }
}
