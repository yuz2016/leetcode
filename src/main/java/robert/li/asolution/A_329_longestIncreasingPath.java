package robert.li.asolution;

public class A_329_longestIncreasingPath {

    int[] xx = new int[]{-1,1,0,0};
    int[] yy = new int[]{0,0,-1,1};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, matrix);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    // 以当前位置未开始的最短路径长度
    int dfs(int x, int y, int[][] matrix) {
        if(dp[x][y] != 0) return dp[x][y];
        for (int i = 0; i < 4; i++) {
            int xx = x + this.xx[i];
            int yy = y + this.yy[i];
            if(xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length
            && matrix[x][y] < matrix[xx][yy]) {
                int dfs = dfs(xx, yy, matrix);
                if(dfs + 1 > dp[x][y]) dp[x][y] = dfs + 1;
            }
        }
        if(dp[x][y] == 0) dp[x][y] = 1;
        return dp[x][y];
    }
}
