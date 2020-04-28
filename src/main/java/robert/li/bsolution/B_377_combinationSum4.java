package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-28
 */
public class B_377_combinationSum4 {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
