package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-20
 */
public class A_32_longestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int res = 0;
        int[] dp = new int[chars.length];
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == ')') {
                if(chars[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0)? dp[i - 2] + 2:2;
                } else {
                    if(dp[i - 1] != 0 && i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 1 > 0) ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
