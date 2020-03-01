package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-23
 */
public class A_10_isMatch {
    public boolean isMatch(String text, String pattern) {
        int[][] dp = new int[text.length() + 1][pattern.length() + 1];
        return helper(text, pattern, 0, 0, dp);
    }

    boolean helper(String s, String p, int i, int j, int[][] dp) {

        if(j >= p.length()) return i == s.length();

        if(dp[i][j] != 0) {
            if(dp[i][j] == 1) {
                return true;
            } else {
                return false;
            }
        }

        boolean first = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean memo = false;
        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            memo = helper(s, p, i, j + 2, dp) ||
                    (first && helper(s, p, i + 1, j, dp));
        } else {
            memo = first && helper(s, p, i + 1, j + 1, dp);
        }

        if(memo) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = -1;
        }
        return memo;
    }

    public static void main(String[] args) {
        A_44_isMatch a_44_isMatch = new A_44_isMatch();
        a_44_isMatch.isMatch("aa","a*");
    }
}
