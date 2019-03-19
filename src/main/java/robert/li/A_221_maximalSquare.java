package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/3/19
 */
public class A_221_maximalSquare {


    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int maxsqlen = 0;
        // 遍历矩阵行
        for (int i = 0; i < rows; i++) {
            // 遍历矩阵列
            for (int j = 0; j < cols; j++) {
                // 当前值为1
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    // 以当前matrix[i][j]为左上坐标，遍历找到最大矩阵，sqlen
                    while (sqlen + i < rows && sqlen + j < cols && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    if (maxsqlen < sqlen) {
                        maxsqlen = sqlen;
                    }
                }

            }
        }
        return maxsqlen * maxsqlen;
    }
}

