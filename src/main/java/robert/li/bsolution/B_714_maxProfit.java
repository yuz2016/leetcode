package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-02
 */
public class B_714_maxProfit {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][2];
        // dp[i][0] 持有
        // dp[i][1] 不持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - 2, dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }
}
