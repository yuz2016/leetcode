package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-23
 */
public class M_0105_oneEditAway {
    public boolean oneEditAway(String first, String second) {
        char[] charsFirst = first.toCharArray();
        char[] charsSecond = second.toCharArray();
        int m = charsFirst.length;
        int n = charsSecond.length;
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(charsFirst[i - 1] == charsSecond[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1], dp[i][j - 1])
                    );
                }
            }
        }
        return dp[m][n] <= 1;
    }

    public static void main(String[] args) {
        M_0105_oneEditAway m = new M_0105_oneEditAway();
        m.oneEditAway("ab", "bc");
    }
}
