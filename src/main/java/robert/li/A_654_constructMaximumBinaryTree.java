package robert.li;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-30
 */
public class A_654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        int maxValueIndex = findMaxValueIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[maxValueIndex]);
        node.left = helper(nums, start, maxValueIndex - 1);
        node.right = helper(nums, maxValueIndex + 1, end);
        return node;
    }

    int findMaxValueIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int res = -1;
        for(int i = start; i <= end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
