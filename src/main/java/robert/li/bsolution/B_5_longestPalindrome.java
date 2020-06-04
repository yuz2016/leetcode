package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-21
 */
public class B_5_longestPalindrome {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(n == 0) return "";
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int res = 1;
        String ss = s.substring(0, 1);
        for (int i = n - 2; i >= 0;i--) {
            for (int j = i + 1; j < n; j++) {
                if(j - i == 1) {
                    if(chars[i] == chars[j]) {
                        dp[i][j] = 2;
                        if(res < 2) {
                            res = 2;
                            ss = s.substring(i, j + 1);
                        }
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if(chars[i] == chars[j] && dp[i + 1][j - 1] == j - i - 1) {
                        dp[i][j] = j - i + 1;
                        if(res < j - i + 1) {
                            res = j - i + 1;
                            ss = s.substring(i, j + 1);
                        }
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return ss;
    }
}
