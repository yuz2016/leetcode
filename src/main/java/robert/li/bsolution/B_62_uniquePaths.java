package robert.li.bsolution;

public class B_62_uniquePaths {
    public int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    arr[j] = 1;
                } else {
                    int right = 0;
                    if (j + 1 < n) {
                        right = arr[j + 1];
                    }
                    arr[j] = arr[j] + right;
                }
            }
        }
        return arr[0];
    }
}
