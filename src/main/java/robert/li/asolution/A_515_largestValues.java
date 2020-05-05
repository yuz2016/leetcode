package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-23
 */
public class A_515_largestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        return list;
    }

    void helper(TreeNode root, int level, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(level + 1 > list.size()) {
            list.add(root.val);
        } else {
            list.set(level, Math.max(list.get(level), root.val));
        }
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }


}
