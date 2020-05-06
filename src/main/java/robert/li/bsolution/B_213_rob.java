package robert.li.bsolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-05
 */
public class B_213_rob {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n - 1);
        int res = helper(tmp);
        System.arraycopy(nums, 1, tmp, 0, n - 1);
        res = Math.max(res, helper(tmp));
        return res;
    }

    int helper(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
