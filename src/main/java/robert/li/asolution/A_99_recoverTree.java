package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-14
 */
public class A_99_recoverTree {
    TreeNode m;
    TreeNode n;
    TreeNode pre;

    // 递归
    public void recoverTree(TreeNode root) {
        inOrderTravesal(root);
        swap(m,n);
    }

    void inOrderTravesal(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrderTravesal(node.left);
        if(pre != null && pre.val > node.val) {
            m = (m == null) ? pre : m;
            n = node;
        }
        pre = node;
        inOrderTravesal(node.right);
    }

    void swap(TreeNode left, TreeNode right){
        if(left != null && right !=null) {
            int cur = left.val;
            left.val = right.val;
            right.val = cur;
        }
    }

    // 迭代
    public void recoverTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode l = null, r = null, pre = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(pre != null && pre.val > node.val) {
                l = (l == null)? pre : l;
                r = node;
            }
            pre = node;
            root = node.right;
        }
        swap(l,r);
    }


}
