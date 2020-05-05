package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-23
 */
public class M_0811_waysToChange {
    public static void main(String[] args) {
        M_0811_waysToChange m_0811_waysToChange = new M_0811_waysToChange();
        int i = m_0811_waysToChange.waysToChange(5);
        System.out.println(i);
        i = m_0811_waysToChange.waysToChange(10);
        System.out.println(i);
    }

    public int waysToChange(int n) {
        int[] coins = { 25, 10, 5, 1 };
        long[][] dp = new long[coins.length + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (int) (dp[coins.length][n] % 1000000007);
    }
}
