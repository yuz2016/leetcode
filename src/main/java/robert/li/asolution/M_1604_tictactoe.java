package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-24
 */
public class M_1604_tictactoe {
    public String tictactoe(String[] board) {
        int n = board.length;
        boolean hasEmpty = false;   //有没有空位
        int[] rowX = new int[n];    //每行有多少个"X"
        int[] colX = new int[n];    //每列有多少个"X"
        int[] rowO = new int[n];
        int[] colO = new int[n];
        // leftX: 从左上角开始的对角线上有多少个"X"
        // rightX: 从右上角开始的对角线上有多少个"X"
        int leftX = 0, rightX = 0, leftO = 0, rightO = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    rowX[i]++;
                    colX[j]++;
                    if (i == j)
                        leftX++;
                    if (i + j == n - 1)
                        rightX++;
                } else if (c == 'O') {
                    rowO[i]++;
                    colO[j]++;
                    if (i == j)
                        leftO++;
                    if (i + j == n - 1)
                        rightO++;
                } else {
                    hasEmpty = true;
                }
            }
        }

        if (leftX == n || rightX == n)
            return "X";
        if (leftO == n || rightO == n)
            return "O";

        for (int i = 0; i < n; i++) {
            if (rowX[i] == n || colX[i] == n)
                return "X";
            if (rowO[i] == n || colO[i] == n)
                return "O";
        }
        return hasEmpty ? "Pending" : "Draw";
    }
}
