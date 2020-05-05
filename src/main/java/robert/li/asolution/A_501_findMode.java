package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-23
 */
public class A_501_findMode {

    int cur = 0;
    int oldCount = 0;
    int newCount = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for(int i = 0; i< list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        helper(root.left, list);
        if(root.val != cur) {
            cur = root.val;
            newCount = 1;
        } else {
            newCount++;
        }
        if(newCount > oldCount) {
            list.clear();
            list.add(cur);
            oldCount = newCount;
        } else if(newCount == oldCount) {
            list.add(cur);
        }
        helper(root.right, list);
    }
}
