package robert.li.bsolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-03
 */
public class B_108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int start, int end) {
        if(start == end) return new TreeNode(nums[start]);
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid > start) {
            root.left = helper(nums, start, mid - 1);
        }
        if(mid < end) {
            root.right = helper(nums, mid + 1, end);
        }
        return root;
    }
}
