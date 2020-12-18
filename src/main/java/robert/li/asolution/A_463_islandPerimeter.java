package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-30
 */
public class A_463_islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    res += calculateGirth(grid, i, j);
                }
            }
        }
        return res;
    }

    int calculateGirth(int[][] grid, int x, int y) {
        int res = 0;
        // 上
        if(x == 0) {
            res++;
        } else {
            if(grid[x - 1][y] == 0) {
                res++;
            }
        }
        // 下
        if(x == grid.length - 1) {
            res++;
        } else {
            if(grid[x + 1][y] == 0) {
                res++;
            }
        }
        // 左
        if(y == 0) {
            res++;
        } else {
            if(grid[x][y - 1] == 0) {
                res++;
            }
        }
        // 右
        if(y == grid[0].length - 1) {
            res++;
        } else {
            if(grid[x][y + 1] == 0) {
                res++;
            }
        }
        return res;
    }
}
