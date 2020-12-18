package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-29
 */
public class B_129_sumNumbers {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        B_129_sumNumbers b_129_sumNumbers = new B_129_sumNumbers();
        int i = b_129_sumNumbers.sumNumbers(node1);
    }

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return res;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if(root.left == null && root.right == null) {
            list.add(root.val);
            plusNode(list);
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        if(root.left != null) {
            dfs(root.left, list);
        }
        if(root.right != null) {
            dfs(root.right, list);
        }
        list.remove(list.size() - 1);
    }

    private void plusNode(List<Integer> list) {
        int b = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            res += (list.get(i) * b);
            b = b * 10;
        }
    }
}
