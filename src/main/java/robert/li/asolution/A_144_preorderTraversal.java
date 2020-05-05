package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-16
 */
public class A_144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while(!treeNodeStack.isEmpty()) {
            TreeNode pop = treeNodeStack.pop();
            list.add(pop.val);
            if(pop.right != null) {
                treeNodeStack.push(pop.right);
            }
            if(pop.left != null) {
                treeNodeStack.push(pop.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

}
