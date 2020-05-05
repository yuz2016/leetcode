package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-02
 */
public class B_309_maxProfit {
    public static void main(String[] args) {
        B_309_maxProfit b_309_maxProfit = new B_309_maxProfit();
        int i = b_309_maxProfit.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][2];
        // dp[i][0] 持有
        // dp[i][1] 不持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], i - 2 < 0 ? - prices[i] : dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }
}
