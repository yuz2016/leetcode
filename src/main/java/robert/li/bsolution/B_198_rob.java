package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-29
 */
public class B_198_rob {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if(i == 0) {
                dp[0] = nums[0];
            } else if(i == 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[n - 1];
    }
}
