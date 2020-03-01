package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-23
 */
public class A_44_isMatch {


    public boolean isMatch(String text, String pattern) {
        int[][] dp = new int[text.length() + 1][pattern.length() + 1];
        return helper(text, pattern, 0, 0, dp);
    }

    boolean helper(String s, String p, int i, int j, int[][] dp) {

        if(j >= p.length()) return i == s.length();

        if(i < s.length() && dp[i][j] != 0) {
            if(dp[i][j] == 1) {
                return true;
            } else {
                return false;
            }
        }

        boolean first = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
        boolean memo = false;
        if(p.charAt(j) == '*') {
            memo = (i == s.length() - 1 && j == p.length() - 1) ||
                    helper(s, p, i, j + 1, dp) ||
                    (i < s.length() - 1 && helper(s, p, i + 1, j, dp));
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
        a_44_isMatch.isMatch("aa","*");
    }
}
