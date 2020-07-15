package robert.li.asolution;

public class A_174_calculateMinimumHP {
    public static void main(String[] args) {
        A_174_calculateMinimumHP a_174_calculateMinimumHP = new A_174_calculateMinimumHP();
        int i = a_174_calculateMinimumHP.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
        System.out.println(i);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0 > Integer.MIN_VALUE);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length < 1) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        // dp[i][j] 表示 到达i，j 带多少血安全
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int down = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE;
                if(i + 1 < m) {
                    down = dp[i + 1][j];
                }
                if(j + 1 < n) {
                    right = dp[i][j + 1];
                }
                int cur = Math.max(right, down);
                if(down == Integer.MIN_VALUE && right == Integer.MIN_VALUE) {
                    cur = 0;
                }
                cur = dungeon[i][j] + cur;
                dp[i][j] = Math.min(cur, 0);
            }
        }
        return -dp[0][0] + 1;
    }
}
