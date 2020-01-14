package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-14
 */
public class A_107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, 0, lists);
        Collections.reverse(lists);
        return lists;
    }

    void helper(TreeNode node, int level, List<List<Integer>> lists) {
        if(node == null) return;
        if(lists.size() < level + 1) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        lists.get(level).add(node.val);
        helper(node.left, level + 1, lists);
        helper(node.right, level + 1, lists);
    }
}
