package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class B_99_recoverTree {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode last = null;
        TreeNode a = null;
        TreeNode b = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(last == null) {
                last = pop;
            } else {
                if(pop.val < last.val) {
                    if(a == null) {
                        a = last;
                        b = pop;
                    } else {
                        b = pop;
                    }
                }
                last = pop;
            }
            root = pop.right;
        }
        swap(a, b);
    }

    private void swap(TreeNode a, TreeNode b) {
        int cur = a.val;
        a.val = b.val;
        b.val = cur;
    }
}
