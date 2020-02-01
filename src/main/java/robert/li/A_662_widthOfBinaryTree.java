package robert.li;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-31
 */
public class A_662_widthOfBinaryTree {

    // 超时
    public int widthOfBinaryTree1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.add(root);
        int max = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            int first = -1, last = -1;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    flag = true;
                    if(first == -1) {
                        first = i;
                        last = i;
                    } else {
                        last = i;
                    }
                    if(poll.left == null) {
                        queue.add(null);
                    } else {
                        queue.add(poll.left);
                    }
                    if(poll.right == null) {
                        queue.add(null);
                    } else {
                        queue.add(poll.right);
                    }
                }
            }
            // queue里元素都为null
            if(!flag) break;
            max = Math.max(max, last - first + 1);
        }
        return max;
    }

    Map<Integer, int[]> map = new HashMap<>();
    int res = 0;
    public int widthOfBinaryTree2(TreeNode root) {
        helper(root,1, 1);
        return res;
    }

    void helper(TreeNode root, int curNodeIndex, int level) {
        if(map.containsKey(level)) {
            int[] ints = map.get(level);
            ints[0] = Math.min(ints[0], curNodeIndex);
            ints[1] = Math.max(ints[1], curNodeIndex);
            res = Math.max(res, ints[1] - ints[0] + 1);
        } else {
            int[] ints = new int[2];
            ints[0] = curNodeIndex;
            ints[1] = curNodeIndex;
            map.put(level, ints);
            res = Math.max(res, ints[1] - ints[0] + 1);
        }
        if(root.left != null) {
            helper(root.left, (curNodeIndex - 1) * 2 + 1, level + 1);
        }
        if(root.right != null) {
            helper(root.right, curNodeIndex * 2, level + 1);
        }
    }



}
