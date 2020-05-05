package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-28
 */
public class A_518_change {
    public static void main(String[] args) {
        A_518_change a_518_change = new A_518_change();
        int change = a_518_change.change(5, new int[] { 1, 2, 5 });
        System.out.println(change);
    }
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(j >= coins[i - 1]) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
