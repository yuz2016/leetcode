package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-08
 */
public class B_221_maximalSquare {
    public static void main(String[] args) {
        char[][] m = {{1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}};
        B_221_maximalSquare b_221_maximalSquare = new B_221_maximalSquare();
        int i = b_221_maximalSquare.maximalSquare(m);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int r = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        int i1 = dp[i - 1][j - 1];
                        int i2 = dp[i - 1][j];
                        int i3 = dp[i][j - 1];
                        int min = Math.min(i1, Math.min(i2, i3));
                        dp[i][j] = min + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
                r = Math.max(r, dp[i][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return r * r;
    }
}
