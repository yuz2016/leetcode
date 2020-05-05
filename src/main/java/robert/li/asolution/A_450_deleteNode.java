package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-22
 */
public class A_450_deleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.right != null) {
                // 找到 右孩子最左节点
                TreeNode node = root.right;
                while(node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
            if(root.left != null) {
                // 找到 左孩子最右节点
                TreeNode node = root.left;
                while(node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                return root.left;
            }
        } else if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            root.right = deleteNode(root.right, key);
            return root;
        }
        return root;
    }
}
