package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/26
 */
public class A_98_IsTwoSearchTree {
    public static void main(String[] args) {

    }

    /**
     * 思路1：
     * 中序遍历，判断
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (Objects.isNull(root)) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        getAll(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    private void getAll(TreeNode node, List<Integer> list) {

        if (Objects.isNull(node)) {
            return;
        }
        getAll(node.left, list);
        list.add(node.val);
        getAll(node.right, list);
    }

    /**
     * Question : Binary Tree Inorder Traversal
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    /**
     * Question : Kth Smallest Element in a BST
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }

    /**
     * Question : Validate Binary Search Tree
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
