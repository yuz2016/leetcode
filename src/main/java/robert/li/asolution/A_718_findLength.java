package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-01
 */
public class A_718_findLength {

    public int findLength(int[] a, int[] b) {
        // do[i][j] 表示以i为结尾 j为结尾的公共子数组
        int[][] dp = new int[a.length][b.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(a[i] == b[j]) {
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
