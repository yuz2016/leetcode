package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-30
 */
public class A_653_findTarget {

    Map<Integer, Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(map.get(root.val) == null) {
            map.put(k - root.val, root.val);
        } else return true;

        boolean left = findTarget(root.left, k);
        if(left) return true;
        boolean right = findTarget(root.right, k);
        if(right) return true;
        return false;
    }

}
