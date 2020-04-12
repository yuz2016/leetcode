package robert.li;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-08
 */
public class M_13_movingCount {

    public static void main(String[] args) {
        M_13_movingCount m = new M_13_movingCount();
        int i = m.movingCount(1, 2, 1);
        System.out.println(i);
        i = m.movingCount(16, 8, 4);
        System.out.println(i);
    }

    //dfs
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    //bfs
    int movingCountBFS(int m, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0 ,0});
        int count = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            if (i >= m || j >= n || largerK(i, j, k) || visited[i][j]) {
                continue;
            }
            count++;
            visited[i][j] = true;
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return count;
    }

    int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || largerK(i, j, k) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    boolean largerK(int i, int j, int k) {
        int sum = sums(i) + sums(j);
        return sum > k;
    }

    int sums(int i) {
        int tmp = 0;
        while (i > 0) {
            tmp += i % 10;
            i = i / 10;
        }
        return tmp;
    }
}
