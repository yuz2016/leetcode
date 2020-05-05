package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-14
 */
public class A_105_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    TreeNode helper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart> inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preStart]);
        int index = map.get(node.val);
        node.left = helper(preOrder, inOrder, preStart + 1, preStart + index - inStart, inStart, index - 1, map);
        node.right = helper(preOrder, inOrder, preStart + index - inStart + 1, preEnd, index + 1, inEnd, map);
        return node;
    }
}
