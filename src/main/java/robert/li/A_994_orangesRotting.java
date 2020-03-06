package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-04
 */
public class A_994_orangesRotting {

    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        // 遍历所有新鲜橘子 如果有一个 4个正方向上为0 则返回-1
        // 没有新鲜橘子返回 -1
        boolean hasNewOrange = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!hasNewOrange && grid[i][j] == 1) hasNewOrange = true;
                boolean b = (i - 1 >= 0? grid[i - 1][j] == 0: true)
                        && (i + 1 < grid.length? grid[i + 1][j] == 0: true)
                        && (j - 1 >= 0? grid[i][j - 1] == 0: true)
                        && (j + 1 < grid[0].length? grid[i][j + 1] == 0: true);
                if(b) return -1;
            }
        }
        if(!hasNewOrange) return -1;


        // 不断遍历 对腐烂橘子四个方向新鲜橘子 更新值 直到 没有新鲜橘子
        int step = 0;
        while(true) {

        }
    }

    int grid[][];
    int r;
    int l;

    public int orangesRotting1(int[][] grid) {
        if (grid.length == 0)
            return -1;
        this.r = grid.length;
        this.l = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {      //烂橘子开始传染病毒
                    dps(i, j, 2);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;            //有新鲜的橘子
                max = Math.max(grid[i][j], max);  //找到烂的 最久的橘子
            }
        }
        return max - 2;
    }

    public void dps(int i, int j, int val) {
        grid[i][j] = val;           //判断周围是新鲜的橘子或者是烂得更慢的橘子

        if (i > 0 && (grid[i - 1][j] == 1 || grid[i - 1][j] - grid[i][j] > 1)) {
            dps(i - 1, j, 1+val);
        }
        if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] - grid[i][j] > 1)) {
            dps(i, j - 1, 1+val);
        }
        if (i < r - 1 && (grid[i + 1][j] == 1 || grid[i + 1][j] - grid[i][j] > 1)) {
            dps(i + 1, j, 1+val);
        }
        if (j < l - 1 && (grid[i][j + 1] == 1 || grid[i][j + 1] - grid[i][j] > 1)) {
            dps(i, j + 1, 1+val);
        }
    }
}
