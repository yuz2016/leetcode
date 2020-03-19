package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-13
 */
public class M_1716_massage {
    int dp[];
    public int massage(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }

    int helper(int[] nums, int i) {
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int doIt = nums[i] + helper(nums, i + 2);
        int notDoIt = helper(nums, i + 1);
        dp[i] = Math.max(doIt, notDoIt);
        return  dp[i];
    }

    
    public int massage1(int[] nums) {
        return helper(nums, 0);
    }


}
