package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/29
 */
public class A_931_MinFallingPathSum {
    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] A) {
        int n = A[0].length;

        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                int best = A[r+1][c];
                if(c>0){
                    best = Math.min(best,A[r+1][c-1]);
                }
                if(c<n-1){
                    best = Math.min(best,A[r+1][c+1]);
                }
                A[r][c] +=best;
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < A[0].length; i++) {
            res = Math.min(res,A[0][i]);
        }
        return res;
    }
}
