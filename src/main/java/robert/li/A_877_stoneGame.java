package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-19
 */
public class A_877_stoneGame {

    public static void main(String[] args) {
        A_877_stoneGame a_877_stoneGame = new A_877_stoneGame();
        a_877_stoneGame.stoneGame(new int[]{5,3,4,5});
        a_877_stoneGame.stoneGame(new int[]{3,7,2,3});
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j][0] = Math.max(piles[i] + dp[i + 1][j][1], piles[j] + dp[i][j - 1][1]);
                dp[i][j][1] = Math.min(dp[i + 1][j][0], dp[i][j - 1][0]);
            }
        }
        return dp[0][n - 1][0] - dp[0][n - 1][1] > 0;
    }
}
