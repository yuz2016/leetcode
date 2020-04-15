package robert.li;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-15
 */
public class A_542_updateMatrix {

    boolean[][] visited;
    int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new boolean[m][n];
        int[][] res = new int[m][n];
        Deque<Pair> queue = new LinkedList<>();
        // 0的位置入队列 并标记为已访问
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            Set<Pair> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;
                res[x][y] = level;
                for (int k = 0; k < direction.length; k++) {
                    int x1 = direction[k][0];
                    int y1 = direction[k][1];
                    if(inArea(x + x1, y + y1, m, n) && !visited[x + x1][y + y1]) {
                        set.add(new Pair(x + x1, y + y1));
                    }
                }
            }
            for (Pair pair : set) {
                visited[pair.x][pair.y] = true;
                queue.add(pair);
            }
            level++;
        }
        return res;
    }

    boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
     }

    class Pair{
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
