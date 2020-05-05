package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-19
 */
public class A_474_findMaxForm {

    public static void main(String[] args) {
        A_474_findMaxForm a = new A_474_findMaxForm();
        int maxForm = a.findMaxForm(new String[] { "10", "0", "1" }, 1, 1);
        System.out.println(maxForm);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // 统计strs 01
        int l = strs.length;
        int[][] strsArr = new int[l][2];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                if (chars[i1] == '0') {
                    strsArr[i][0]++;
                } else {
                    strsArr[i][1]++;
                }
            }
        }

        int[][][] dp = new int[m + 1][n + 1][l + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int x = 1; x <= l; x++) {
                    int[] arr = strsArr[x - 1];
                    int a = arr[0];
                    int b = arr[1];
                    if (i - a >= 0 && j - b >= 0) {
                        dp[i][j][x] = Math.max(dp[i - a][j - b][x - 1] + 1, dp[i][j][x - 1]);
                    } else {
                        dp[i][j][x] = dp[i][j][x - 1];
                    }
                }
            }
        }
        return dp[m][n][l];
    }
}
