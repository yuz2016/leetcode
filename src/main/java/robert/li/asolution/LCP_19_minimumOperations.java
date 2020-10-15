package robert.li.asolution;

public class LCP_19_minimumOperations {
    public int minimumOperations(String leaves) {
        if(leaves == null || leaves.length() == 0) return 0;
        char[] chars = leaves.toCharArray();
        int[][] dp = new int[leaves.length()][3];

        dp[0][0] = chars[0] == 'y'? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < leaves.length(); i++) {
            int isYellow = chars[i] == 'y'? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1 - isYellow;
            if(i > 1) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
            }
        }
        return dp[leaves.length() - 1][2];
    }
}
