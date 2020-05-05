package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-20
 */
public class A_213_rob {

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
    }

    public int helper(int[] nums, int start, int end) {
        int dp1 = 0, dp2 = 0;
        int tmp = 0;
        for(int i = end; i>=start; i--) {
            tmp = Math.max(nums[i] + dp2, dp1);
            dp2 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        A_213_rob a = new A_213_rob();
        int[] t = {1,3,1,3,1};
        int rob = a.rob(t);
        System.out.println(rob);
    }
}
