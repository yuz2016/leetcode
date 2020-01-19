package robert.li;

import robert.li.common.TreeNode;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-18
 */
public class A_173_BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public A_173_BSTIterator(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        TreeNode node = res.right;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
