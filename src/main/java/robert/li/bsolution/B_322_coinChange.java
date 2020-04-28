package robert.li.bsolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-26
 */
public class B_322_coinChange {
    public static void main(String[] args) {
        B_322_coinChange b = new B_322_coinChange();
        int i = b.coinChange1(new int[] { 1, 2, 5 }, 11);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], amount + 1);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int coin = coins[i - 1];
                if (coin <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coin]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n] == amount + 1 ? -1 : dp[m][n];
    }

    public int coinChange1(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], amount + 1);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                int coin = coins[i - 1];
                if (coin <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coin]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n] == amount + 1 ? -1 : dp[m][n];
    }
}
