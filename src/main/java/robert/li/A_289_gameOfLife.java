package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-02
 */
public class A_289_gameOfLife {

    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 0) {
                    if(aroundAliveCell(tmp, i, j, m, n) == 3) {
                        board[i][j] = 1;
                    }
                }
                if (tmp[i][j] == 1) {
                    int count = aroundAliveCell(tmp, i, j, m, n);
                    if(count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    private int aroundAliveCell(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int[] d : directions) {
            int x = d[0];
            int y = d[1];
            if(inArea(i + x, j + y, m, n) && board[i + x][j + y] == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean inArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
