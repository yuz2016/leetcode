package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class B_113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, res, list, 0, sum);
        return res;
    }

    void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int curSum, int sum) {
        if(root == null) return;
        if (root.left == null && root.right == null && curSum + root.val == sum) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if(root.left != null) {
            list.add(root.val);
            dfs(root.left, res, list, curSum + root.val, sum);
            list.remove(list.size() - 1);
        }
        if(root.right != null) {
            list.add(root.val);
            dfs(root.right, res, list, curSum + root.val, sum);
            list.remove(list.size() - 1);
        }
    }
}
