package robert.li;

import robert.li.common.TreeNode;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/23
 */
public class A_230_kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root !=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(--k == 0){
                return pop.val;
            }
            root = pop.right;
        }
        return -1;
    }
}
