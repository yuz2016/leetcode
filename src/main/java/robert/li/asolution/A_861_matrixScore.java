package robert.li.asolution;

public class A_861_matrixScore {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            // 如果第 i 行以 0 开头
            if (A[i][0] == 0) {
                // 行翻转
                for (int j = 0; j < n; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            // 统计第 j 列有多少个 1。
            for (int i = 0; i < m; i++) {
                cnt += A[i][j];
            }
            // max(cnt, m - cnt) 表示这个位置最多有多少个 1。 1<<(n-j-1) 表示这个位置的1的大小。
            result += Math.max(cnt, m - cnt) * (1 << (n - j - 1));
        }
        return result;
    }
}
