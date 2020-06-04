package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-19
 */
public class A_680_validPalindrome {

    // 超内存
    public boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n;j++) {
                if(chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] <= 1;
    }

    // 超时
    public boolean validPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(isPalindrome(chars)) return true;
        for (int i = 0; i < n; i++) {
            if(isPalindrome(chars, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        return isPalindrome(chars);
    }

    private boolean isPalindrome(char[] chars) {
        int n = chars.length;
        int i = 0, j = n - 1;
        while(i < j) {
            if(chars[i] != chars[j]) {
                return isPalindrome(chars, i) || isPalindrome(chars, j);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int del) {
        int n = chars.length;
        int i = 0, j = n - 1;
        while(i < j) {
            if(i == del) {
                i++;
                continue;
            }

            if(j == del) {
                j--;
                continue;
            }

            if(chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
