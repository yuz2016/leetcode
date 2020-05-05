package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/29
 */
public class A_198_rob {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        for (int i = 1; i <= nums.length; i++) {

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i-1];
        }
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
    }

    // 递归 自顶向下
    int[] memo;
    public int rob1(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    int helper(int[] nums, int start) {
        if(start > nums.length - 1) {
            return 0;
        }
        if(memo[start] != -1) return memo[start];
        int max = Math.max(nums[start] + helper(nums, start + 2), helper(nums, start + 1));
        memo[start] = max;
        return max;
    }

    // 自底向上
    public int rob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        for(int i = len - 1; i>=0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    public int rob3(int[] nums) {
        int len = nums.length;
        int dp1 = 0, dp2 = 0;
        int tmp = 0;
        for(int i = len - 1; i>=0; i--) {
            tmp = Math.max(nums[i] + dp2, dp1);
            dp2 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }

}
