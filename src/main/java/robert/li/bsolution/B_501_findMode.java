package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-24
 */
public class B_501_findMode {

    List<Integer> res = new LinkedList<>();
    int cur = -1;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        midOrder(root);
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    void midOrder(TreeNode root) {
        if(root == null) return;
        midOrder(root.left);
        int val = root.val;
        if(cur == -1) {
            cur = val;
            count = 1;
        } else {
            if(cur == val) {
                count++;
            } else {
                cur = val;
                count = 1;
            }
        }
        if(count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(val);
        } else if(count == maxCount){
            res.add(val);
        }
        midOrder(root.right);
    }
}
