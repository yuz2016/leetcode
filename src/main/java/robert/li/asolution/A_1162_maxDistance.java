package robert.li.asolution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-29
 */
public class A_1162_maxDistance {
    public int maxDistance(int[][] grid) {
        // 方向向量
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // 由于题目中给出了 grid 的范围，因此不用做输入检查
        int n = grid.length;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(getIndex(i, j, n));
                }
            }
        }

        if(queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                int currentX = poll / n;
                int currentY = poll % n;
                for (int j = 0; j < directions.length; j++) {
                    int newX = currentX + directions[j][0];
                    int newY = currentY + directions[j][1];
                    if (inArea(newX, newY, n) && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        queue.add(getIndex(newX, newY, n));
                    }
                }
            }
            step++;
        }
        return step - 1;
    }

    int getIndex(int i, int j, int n) {
        return i * n + j;
    }

    boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
