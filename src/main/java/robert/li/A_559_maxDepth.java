package robert.li;

import robert.li.common.Node;
import robert.li.common.TreeNode;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-25
 */
public class A_559_maxDepth {
    int max = 0;
    public int maxDepth(Node root) {
        helper(root, 1);
        return max;
    }

    void helper(Node root, int level) {
        if(root == null) return ;
        max = Math.max(level, max);
        for(int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i), level + 1);
        }
    }
}
