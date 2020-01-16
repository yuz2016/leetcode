package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-15
 */
public class A_114_flatten {
    /**
     * 误解展开规则
     *
     * @param root
     */
    public void flattenError(TreeNode root) {

        // 遍历一遍树 获得一个TreeNode list
        List<TreeNode> list = new ArrayList<>();
        helper(list, root);
        // 根据node val值 排序
        list.sort(new Comparator<TreeNode>() {
            @Override public int compare(TreeNode o1, TreeNode o2) {
                return o1.val - o2.val;
            }
        });
        // 一次连成一个链表
        if(list.size() < 2) {
            return;
        }
        list.get(0).left = null;
        for(int i = 1; i < list.size(); i++) {
            list.get(i - 1).right = list.get(i);
            list.get(i).left = null;
        }
    }

    void helper(List<TreeNode>list, TreeNode root) {
        if(root == null) return;
        list.add(root);
        helper(list, root.left);
        helper(list, root.right);
    }

    public void flatten(TreeNode root) {
        while(root != null) {

            if(root.left == null) {
                root = root.right;
            } else {
                // 找左子树的最右节点
                TreeNode node = root.left;
                while(node.right != null) {
                    node = node.right;
                }
                // 插入右子树
                node.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
