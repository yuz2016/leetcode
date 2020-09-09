package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-04
 */
public class B_257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        for (List<Integer> re : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < re.size(); i++) {
                if(i == 0) {
                    sb.append(re.get(i));
                } else {
                    sb.append("->").append(re.get(i));
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    void dfs(TreeNode root, List<Integer> list, List<List<Integer>> res) {
        if(root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if(root.left != null) {
            list.add(root.val);
            dfs(root.left, list, res);
            list.remove(list.size() - 1);
        }
        if(root.right != null) {
            list.add(root.val);
            dfs(root.right, list, res);
            list.remove(list.size() - 1);
        }

    }
}
