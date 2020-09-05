package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-08-28
 */
public class A_657_judgeCircle {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int row = 0, col = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'R') {
                row--;
            }
            if(chars[i] == 'L') {
                row++;
            }
            if(chars[i] == 'D') {
                col--;
            }
            if(chars[i] == 'U') {
                col++;
            }
        }
        return row == 0 && col == 0;
    }
}
