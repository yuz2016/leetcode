package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/11/11
 */
public class A_938_RangeSumBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean flag = false;
        int sum = 0;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.val == L) {
                flag = true;
            }

            if (flag) {
                sum += root.val;
            }

            if (root.val == R) {
                flag = false;
            }
            root = root.right;
        }

        return sum;

    }

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null)
            return 0; // base case.
        if (root.val < L)
            return rangeSumBST(root.right, L, R); // left branch excluded.
        if (root.val > R)
            return rangeSumBST(root.left, L, R); // right branch excluded.
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); // count in both children.
    }
}
