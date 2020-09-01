package robert.li.asolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-08-24
 */
public class A_529_updateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {

        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        if (board[row][col] == 'E') {
            bfs(board, row, col);
        }

        return board;
    }

    // 题目要求是：只有字符确定为B才能递归遍历周围的
    private void bfs(char[][] board, int row, int col) {

        int[][] direcs = {
                {1, -1}, {1, 0}, {1, 1},
                {0, -1}, {0, 1},
                {-1, -1}, {-1, 0}, {-1, 1}};

        Set<Pos> set = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row, col});
        set.add(new Pos(row, col));
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int cnt = 0;// 炸弹个数
            for (int[] direc : direcs) {
                int curR = cur[0] + direc[0], curC = cur[1] + direc[1];
                if (curR >= 0 && curR < board.length && curC >= 0 && curC < board[0].length && board[curR][curC] == 'M') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                board[cur[0]][cur[1]] = (char) (cnt + '0');
            } else {
                board[cur[0]][cur[1]] = 'B';
                for (int[] direc : direcs) {
                    int curR = cur[0] + direc[0], curC = cur[1] + direc[1];
                    Pos next = new Pos(curR, curC);
                    // 边界条件的限定
                    if (curR >= 0 && curR < board.length && curC >= 0 && curC < board[0].length
                            && board[curR][curC] == 'E' && !set.contains(next)) {
                        deque.addLast(new int[]{curR, curC});
                        set.add(next);
                    }
                }
            }
        }
    }

    class Pos{
        int x,y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {

        A_529_updateBoard updateBoard = new A_529_updateBoard();

        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};
        updateBoard.updateBoard(board, click);

    }
}
