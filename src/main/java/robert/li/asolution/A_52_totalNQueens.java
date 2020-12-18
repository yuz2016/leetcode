package robert.li.asolution;

public class A_52_totalNQueens {

    int count = 0;

    public int totalNQueens(int n) {
        boolean[][] lists = new boolean[n][n];
        backTrace(0, lists, n);
        return count;
    }

    void backTrace(int startIndex, boolean[][] lists, int n) {
        if (startIndex == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(startIndex, i, lists, n)) continue;
            lists[startIndex][i] = true;
            backTrace(startIndex + 1, lists, n);
            lists[startIndex][i] = false;
        }
    }

    boolean isValid(int x, int y, boolean[][] lists, int n) {
        for (int i = x - 1; i >= 0; i--) {
            if (lists[i][y]) {
                return false;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (lists[i][j]) {
                return false;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (lists[i][j]) {
                return false;
            }
        }
        return true;
    }
}
