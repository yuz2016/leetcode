package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-20
 */
public class A_200_numIslands {

    int[][] directer = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        if(grid.length < 1) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                    continue;
                }
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j, visited, m, n);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y, boolean[][] visited, int m, int n) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            int b = poll[1];
            for (int i = 0; i < directer.length; i++) {
                int[] ints = directer[i];
                int dX = ints[0];
                int dY = ints[1];
                int curX = a + dX;
                int curY = b + dY;
                if(inArea(curX, curY, m, n) && grid[curX][curY] == '1' && !visited[curX][curY]) {
                    queue.add(new int[] {curX, curY});
                    visited[curX][curY] = true;
                }
            }
        }
    }

    private boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
