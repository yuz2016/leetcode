package robert.li.asolution;

public class A_566_matrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if( m * n != r * c) return nums;
        int[][] res = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = nums[x][y];
                y++;
                if(y == n) {
                    x++;
                    y = 0;
                }
            }
        }
        return res;
    }
}
