package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-21
 */
public class A_188_maxProfit {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k > n/2) return maxProfit_k(prices);
        int[][][] dp = new int[n][k + 1][2];
        for(int i = 0;i < n; i++) {
            for(int j = k; j>=1;j--) {
                if(i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                }
            }
        }
        return dp[n-1][k][0];
    }


    public int maxProfit_k(int[] prices) {
        if(prices.length == 0) return 0;
        int a0 = 0, a1 = -prices[0];
        for(int i = 1; i < prices.length;i++) {
            a0 = Math.max(a0, a1 + prices[i]);
            a1 = Math.max(a1, a0 - prices[i]);
        }
        return a0;
    }
}
