package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-01
 */
public class B_486_PredictTheWinner {
    public static void main(String[] args) {
        B_486_PredictTheWinner b_486_predictTheWinner = new B_486_PredictTheWinner();
        b_486_predictTheWinner.PredictTheWinner(new int[]{1,5,2});
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = 0;
        }
        for(int i = n - 2; i >= 0; i--) {
            for( int j = i + 1; j < n; j++) {
                dp[i][j][0] = Math.max(nums[i] + dp[i + 1][j][1], nums[j] + dp[i][j - 1][1]);
                dp[i][j][1] = Math.min(dp[i + 1][j][0], dp[i][j - 1][0]);
            }
        }
        return dp[0][n - 1][0] - dp[0][n - 1][1] > 0;
    }
}
