package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-23
 */
public class A_1143_longestCommonSubsequence {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        return dp(chars1, chars2, text1.length() - 1, text2.length() - 1);
    }

    int dp(char[] chars1, char[] chars2, int i, int j) {
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        int res;
        if(chars1[i] == chars2[j]) {
            res = dp(chars1, chars2, i - 1,j - 1) + 1;
        } else {
            res = Math.max(dp(chars1, chars2, i - 1,j), dp(chars1, chars2, i,j - 1));
        }
        memo[i][j] = res;
        return res;
    }
}
