package robert.li.bsolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-07
 */
public class B_300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
