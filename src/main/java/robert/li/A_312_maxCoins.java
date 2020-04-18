package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-18
 */
public class A_312_maxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] nums2 = new int[n + 2];
        System.arraycopy(nums, 0, nums2, 1, n);
        nums2[0] = 1;
        nums2[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        int length = dp.length;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, dp[i][k] + dp[k][j] + nums2[i] * nums2[j] * nums2[k]);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length - 1];
    }
}
