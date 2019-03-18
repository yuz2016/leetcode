package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/26
 */
public class A_103_zigzagLevelOrder {

    /**
     * queue
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        TreeNode t = new TreeNode(-1);
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        ((LinkedList<TreeNode>) queue).addLast(root);
        ((LinkedList<TreeNode>) queue).add(t);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (queue.peek() != t) {
                TreeNode pop = ((LinkedList<TreeNode>) queue).pop();
                list.add(pop.val);
                if (pop.left != null) {
                    ((LinkedList<TreeNode>) queue).addLast(pop.left);
                }
                if (pop.right != null) {
                    ((LinkedList<TreeNode>) queue).addLast(pop.right);
                }
            }
            TreeNode pop = ((LinkedList<TreeNode>) queue).pop();
            if (!queue.isEmpty()) {
                ((LinkedList<TreeNode>) queue).addLast(pop);
            }
            if (!flag) {
                Collections.reverse(list);
            }
            lists.add(list);
            if (flag) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return lists;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
