package robert.li;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-14
 */
public class A_106_buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1, map);
    }

    TreeNode helper(int[] postOrder, int[] inOrder, int postStart, int postEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postOrder[postEnd]);
        int index = map.get(node.val);
        node.left = helper(postOrder, inOrder, postStart, postStart + index - inStart - 1, inStart, index - 1, map);
        node.right = helper(postOrder, inOrder, postStart + index - inStart, postEnd - 1, index + 1, inEnd, map);
        return node;
    }
}
