package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-08
 */
public class B_887_superEggDrop {
    public static void main(String[] args) {
        B_887_superEggDrop b_887_superEggDrop = new B_887_superEggDrop();
        int i = b_887_superEggDrop.superEggDrop(2, 2);
        System.out.println(i);
    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = N + 1;
                for(int k = j - 1; k >= 1; k--) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }
        return dp[K][N];
    }
}
