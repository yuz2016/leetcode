package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-15
 */
public class A_695_maxAreaOfIsland {

    // 记录是否访问过
    int[][] memo;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (memo[i][j] != 0) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    memo[i][j] = 1;
                    continue;
                }
                res = Math.max(res, helper(i, j, grid));
            }
        }
        return res;
    }

    // 返回 [i,j] 所属岛屿 1的节点数
    int helper(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i > m - 1) return 0;
        if(j < 0 || j > n - 1) return 0;

        if (memo[i][j] != 0) {
            return 0;
        }
        if (grid[i][j] == 0) {
            memo[i][j] = 1;
            return 0;
        }
        memo[i][j] = 1;
        return 1 + helper(i - 1, j, grid)
                + helper(i + 1, j, grid)
                + helper(i, j - 1, grid)
                + helper(i, j + 1, grid);
    }
}
