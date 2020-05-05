package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-23
 */
public class A_508_findFrequentTreeSum {
    int oldCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for(int i = 0; i< list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int helper(TreeNode root, List<Integer> list) {
        if(root == null) return 0;
        int left = helper(root.left, list);
        int right = helper(root.right, list);
        // 计算当前节点的子树元素和 更新map
        int cur = left + right + root.val;
        int newCount = map.getOrDefault(cur, 0) + 1;
        map.put(cur, newCount);

        // 更新list
        if(newCount > oldCount) {
            list.clear();
            list.add(cur);
            oldCount = newCount;
        } else if(newCount == oldCount) {
            list.add(cur);
        }
        return cur;
    }
}
