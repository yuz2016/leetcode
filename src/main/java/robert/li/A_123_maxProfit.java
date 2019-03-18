package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/23
 */
public class A_123_maxProfit {

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }


    // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
    // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
    //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
    // f[0, ii] = 0; 0 times transation makes 0 profit
    // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade

    public static int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int k = 2;// 交易次数
        int maxProfit = 0;

        int[][] dp = new int[k + 1][prices.length];
        for (int kk = 1; kk < dp.length; kk++) {
            int maxTmp = dp[kk - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[kk][j] = Math.max(dp[kk][j - 1], prices[j] + maxTmp);
                maxTmp = Math.max(maxTmp, dp[kk - 1][j] - prices[j]);
                maxProfit = Math.max(maxProfit, dp[kk][j]);
            }
        }

        return maxProfit;

    }
}
