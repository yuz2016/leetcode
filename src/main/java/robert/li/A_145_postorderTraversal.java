package robert.li;

import robert.li.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-21
 */
public class A_145_postorderTraversal {
    /**
     * 先序遍历
     * 根 -》左 -》右
     * 头插
     * 右 -》左 -》根
     * 调整左右节点访问顺序
     * 左 -》右 -》根
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(0, pop.val);
            if(pop.left != null) stack.push(pop.left);
            if(pop.right != null) stack.push(pop.right);
        }
        return res;
    }
}
