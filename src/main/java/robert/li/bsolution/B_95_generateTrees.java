package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-21
 */
public class B_95_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        if(start > end) return null;
        List<TreeNode> res = new LinkedList<>();
        for(int i = start; i <= end; i++) {
            List<TreeNode> lList = helper(start, i - 1);
            List<TreeNode> rList = helper(i + 1, end);
            if(lList == null && rList == null) {
                TreeNode node = new TreeNode(i);
                res.add(node);
            } else if(lList == null) {
                for (TreeNode node : rList) {
                    TreeNode cur = new TreeNode(i);
                    cur.right = node;
                    res.add(cur);
                }
            } else if(rList == null) {
                for (TreeNode node : lList) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = node;
                    res.add(cur);
                }
            } else {
                for (TreeNode l : lList) {
                    for (TreeNode r : rList) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = l;
                        cur.right = r;
                        res.add(cur);
                    }
                }
            }
        }
        return res;
    }
}
