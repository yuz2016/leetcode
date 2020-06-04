package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-22
 */
public class B_105_buildTree {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return helper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    public TreeNode helper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        Integer rootInOrderIndex = map.get(preOrder[preStart]);
        int leftCount = rootInOrderIndex - inStart;
        root.left = helper(preOrder, inOrder, preStart + 1, leftCount + preStart, inStart, rootInOrderIndex - 1);
        root.right = helper(preOrder, inOrder, leftCount + preStart + 1, preEnd, rootInOrderIndex + 1, inEnd);
        return root;
    }
}
