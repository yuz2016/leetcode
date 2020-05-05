package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/4/3
 */
public class A_72_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }


    char[] chars1, chars2;
    int[][] dp;
    public int minDistance1(String word1, String word2) {
        chars1 = word1.toCharArray();
        chars2 = word2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(chars1.length - 1, chars2.length - 1);
    }

    int helper(int i, int j) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(chars1[i] == chars2[j]) {

            int res = helper(i - 1, j - 1);
            dp[i][j] = res;
            return res;
        } else {
            int delete = 1 + helper(i - 1, j);
            int change = 1 + helper(i - 1, j - 1);
            int add = 1 + helper(i, j - 1);
            int res = Math.min(delete, Math.min(change, add));
            dp[i][j] = res;
            return res;
        }
    }
}
