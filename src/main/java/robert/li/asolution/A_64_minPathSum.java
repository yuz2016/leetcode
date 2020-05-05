package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-12
 */
public class A_64_minPathSum {

    int[][] memo;

    public int minPathSum(int[][] grid) {

        int m = grid.length - 1, n = grid[0].length - 1;
        memo = new int[m + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(grid,m,n);
    }

    // 到达 <i,j> 的 minPathSum
    int helper(int[][] grid,int i, int j) {
        if(memo[i][j] != -1) return memo[i][j];
        if(i == 0 && j == 0) {
            memo[i][j] = grid[i][j];
            return memo[i][j];
        }
        if(i == 0) {
            memo[i][j] = helper(grid, i, j - 1) + grid[i][j];
            return memo[i][j];
        }
        if(j == 0) {
            memo[i][j] = helper(grid, i - 1, j) + grid[i][j];
            return memo[i][j];
        }
        memo[i][j] = Math.min(helper(grid, i, j - 1), helper(grid, i - 1, j)) + grid[i][j];
        return memo[i][j];
    }



    public int minPathSum1(int[][] grid) {

        int[] memo = new int[grid[0].length];

        for (int j = 0; j < grid[0].length; j++) {
            if(j == 0) {
                memo[j] = grid[0][j];
            } else {
                memo[j] = memo[j - 1] + grid[0][j];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(j == 0) {
                    memo[j] = memo[j] + grid[i][j];
                } else {
                    memo[j] = Math.min(memo[j - 1], memo[j]) + grid[i][j];
                }
            }
        }
        return memo[memo.length - 1];
    }
}
