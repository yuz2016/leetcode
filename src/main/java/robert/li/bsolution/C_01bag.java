package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-19
 */
public class C_01bag {

    public static void main(String[] args) {
        C_01bag c = new C_01bag();
        int i = c.maxWeight(new int[] { 2, 1, 3 }, new int[] { 4, 2, 3 }, 4);
        System.out.println(i);
    }

    public int maxWeight(int[] v, int[] w, int t) {
        int n = v.length;
        int[][] dp = new int[t + 1][n + 1];
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= n; j++) {
                if(i - v[j - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - v[j - 1]][j - 1] + w[j - 1], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t][n];
    }
}
