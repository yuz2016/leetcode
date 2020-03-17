package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-13
 */
public class A_63_uniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] arr = new int[m][n];

        boolean hasObstacleOnRow = false;
        boolean hasObstacleOnCol = false;
        for (int i = 0; i < m; i++) {
            if(!hasObstacleOnRow) {
                if(obstacleGrid[i][0] == 1) {
                    hasObstacleOnRow = true;
                    arr[i][0] = 0;
                } else {
                    arr[i][0] = 1;
                }

            } else {
                arr[i][0] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if(!hasObstacleOnCol) {
                if(obstacleGrid[0][i] == 1) {
                    hasObstacleOnCol = true;
                    arr[0][i] = 0;
                } else {
                    arr[0][i] = 1;
                }

            } else {
                arr[0][i] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        A_63_uniquePathsWithObstacles a = new A_63_uniquePathsWithObstacles();

        a.uniquePathsWithObstacles(arr);
    }
}
