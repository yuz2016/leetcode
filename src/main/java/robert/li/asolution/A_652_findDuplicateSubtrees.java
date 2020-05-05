package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-29
 */
public class A_652_findDuplicateSubtrees {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    String helper(TreeNode root) {
        if(root == null) return "#";
        String s = root.val + "," + helper(root.left) + "," + helper(root.right);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if(map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }
}
