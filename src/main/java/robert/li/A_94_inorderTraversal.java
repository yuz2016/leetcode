package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/23
 */
public class A_94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            root = pop.right;
        }
        return list;
    }

}
