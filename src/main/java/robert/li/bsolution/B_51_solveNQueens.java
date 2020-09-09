package robert.li.bsolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-03
 */
public class B_51_solveNQueens {

    public static void main(String[] args) {
        B_51_solveNQueens b_51_solveNQueens = new B_51_solveNQueens();
        List<List<String>> lists = b_51_solveNQueens.solveNQueens(5);
        double b = 4/3;
        int i = 1;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<int[]> positions = new ArrayList<>();
        dfs(res, 0, n, list, positions);
        return res;
    }

    void dfs(List<List<String>> res, int start, int n, List<String> list, List<int[]> positions) {
        if(start == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(checkSlant(positions, start, i)) {
                continue;
            }
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            String s = new String(chars);
            list.add(s);
            positions.add(new int[] {start, i});
            dfs(res, start  + 1, n, list, positions);
            list.remove(list.size() - 1);
            positions.remove(positions.size() - 1);
        }
    }

    private boolean checkSlant(List<int[]> positions, int x, int y) {
        for (int[] position : positions) {
            double row = position[0] - x;
            double col = position[1] - y;
            double i = col / row;
            if(i == 1.0 || i == -1.0) {
                return true;
            }
            if(position[1] == y) {
                return true;
            }
        }
        return false;
    }


}
