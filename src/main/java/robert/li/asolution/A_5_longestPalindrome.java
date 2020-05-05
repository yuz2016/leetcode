package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-15
 */
public class A_5_longestPalindrome {


    public class Solution {

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            boolean[][] dp = new boolean[len][len];

            // 初始化
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            int maxLen = 1;
            int start = 0;

            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {

                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }

                    // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j]) {
                        int curLen = j - i + 1;
                        if (curLen > maxLen) {
                            maxLen = curLen;
                            start = i;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }

    /**
     * 有问题
     * eg:ccc
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";

        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        int start = 0;
        int maxLen = 1;
        for (int i = 1; i < chars.length; i++) {
            int m = memo[i - 1];
            if (m == 1) {
                if (i - 2 >= 0 && chars[i - 2] == chars[i]) {
                    memo[i] = 3;
                } else if (chars[i - 1] == chars[i]) {
                    memo[i] = 2;
                }
            } else {
                if (i - m - 1 >= 0 && chars[i - m - 1] == chars[i]) {
                    memo[i] = m + 2;
                }
            }
            if (memo[i] > maxLen) {
                maxLen = memo[i];
                start = i - memo[i] + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        A_5_longestPalindrome a = new A_5_longestPalindrome();
        String res = a.longestPalindrome("abcdeffedcba");
        System.out.println(res);
    }
}
