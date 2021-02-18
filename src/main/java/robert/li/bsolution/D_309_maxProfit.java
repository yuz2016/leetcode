package robert.li.bsolution;

public class D_309_maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        int length = prices.length;
        int[][] dp = new int[length][3];
        // 不操作不持股
        dp[0][0] = 0;
        // 持股
        dp[0][1] = -prices[0];
        // 卖出不持股
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[length - 1][0], dp[length - 1][2]);
    }
}
