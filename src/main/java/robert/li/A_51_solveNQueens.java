package robert.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-06
 */
public class A_51_solveNQueens {
    public static void main(String[] args) {
        A_51_solveNQueens a = new A_51_solveNQueens();
        a.solveNQueens(4);
    }

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backTrack(board, 0);
        return res;
    }

    // 路径:小于row的行上都已成功放置
    // 选择列表:第row行的所有列都是放置皇后的选择
    // 结束条件:row超过board
    void backTrack(char[][] board, int row) {

        if(row == board.length) {
            List<String> strings = listToArr(board);
            res.add(strings);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            // 排除不合法选择
            if(!isValid(board, row, i)) {
                continue;
            }

            // 选择
            board[row][i] = 'Q';
            backTrack(board, row + 1);
            // 撤销选贼
            board[row][i] = '.';
        }
    }

    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }


    List<String> listToArr(char[][] board) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }

}
