package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-25
 */
public class B_106_buildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return preOrder(map, inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    TreeNode preOrder(Map<Integer, Integer> map, int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        TreeNode node = new TreeNode(postOrder[postEnd]);
        Integer index = map.get(postOrder[postEnd]);
        node.left = preOrder(map, inOrder, postOrder, inStart, index - 1, postStart, postStart + index - 1 - inStart);
        node.right = preOrder(map, inOrder, postOrder, index + 1, inEnd, postEnd - (inEnd - index), postEnd - 1);
        return node;
    }
}
