package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-05
 */
public class M_29_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int size = matrix[0].length * matrix.length;
        int[] res = new int[size];
        int index = 0;
        while(true) {
            for(int i = l; i <= r; i++) res[index++] = matrix[t][i];
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[index++] = matrix[i][r];
            if(--r < l) break;
            for(int i = r; i >= l; i--) res[index++] = matrix[b][i];
            if(--b < t) break;
            for(int i = b; i >= t; i--) res[index++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }
}
