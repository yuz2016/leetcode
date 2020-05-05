package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-15
 */
public class A_113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return lists;
        helper(lists, list, root, sum);
        return lists;
    }

    void helper(List<List<Integer>> lists, List<Integer> list, TreeNode root, int sum) {
        if(root == null) return;
        int newSum = sum - root.val;
        list.add(root.val);
        if(newSum == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }

        if(root.left != null) {
            helper(lists, list, root.left, sum - root.val);
        }

        if(root.right != null) {
            helper(lists, list, root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }
}
