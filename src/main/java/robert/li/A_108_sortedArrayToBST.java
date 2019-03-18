package robert.li;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/31
 */
public class A_108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length<1) {
            return null;
        }
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums , int low, int high){

        if(low >high){
            return null;
        }
        int tmp = (low + high)/2;
        TreeNode treeNode = new TreeNode(nums[tmp]);
        treeNode.left = helper(nums, low , tmp - 1);
        treeNode.right = helper(nums, tmp + 1,high);
        return treeNode;
    }
}
