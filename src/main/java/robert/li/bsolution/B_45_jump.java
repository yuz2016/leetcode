package robert.li.bsolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-17
 */
public class B_45_jump {
    // dp
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dp(nums, n - 1, dp);
    }

    int dp(int[] nums, int i, int[] dp) {
        if(i == 0) return 0;
        if(dp[i] != -1) return dp[i];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if(j + nums[j] >= i) {
                res = Math.min(res, dp(nums, j, dp) + 1);
            }
        }
        dp[i] = res;
        return res;
    }

    // 贪心
    public int jump2(int[] nums) {
        if(nums.length == 0) return 0;
        int maxIndex = 0;
        int end = 0;
        int step = 0;
        for(int i = 0; i < nums.length; i++) {
            maxIndex = Math.max(i + nums[i], maxIndex);
            if(end == i) {
                step++;
                end = maxIndex;
            }
        }
        return step;
    }
}
