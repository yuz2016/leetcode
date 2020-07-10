package robert.li.bsolution;

public class C_309_maxProfit {
    public static void main(String[] args) {

        C_309_maxProfit c_309_maxProfit = new C_309_maxProfit();
        int i = c_309_maxProfit.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }


    // 位置i 的选择
    // 当前位置不持有的选择 不操作 或 卖出
    // 当前位置持有的选择  不操作 或 买入
    // i状态 持有 不持有
    // dp[0][i] 表示 当前不持有 最大利润
    // dp[1][i] 表示  当前持有 最大利润
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], prices[i] + dp[1][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 1], i - 2 >= 0 ? dp[0][i - 2] - prices[i] : - prices[i]);
        }
        return dp[0][prices.length - 1];
    }
}
