package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-06
 */
public class B_63_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    if(obstacleGrid[i][j] == 1) {
                        dp[0][0] = 0;
                    } else {
                        dp[0][0] = 1;
                    }
                    continue;
                }
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }
                int left = 0;
                if(i - 1 >= 0) {
                    left = dp[i - 1][j];
                }
                int top = 0;
                if(j - 1 >= 0) {
                    top = dp[i][j - 1];
                }
                dp[i][j] = left + top;
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
