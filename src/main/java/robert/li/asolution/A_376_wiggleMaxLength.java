package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-07
 */
public class A_376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j][1] == 0) {
                    if(nums[i] > nums[j]) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                        dp[i][1] = 1;
                    }
                    if(nums[i] < nums[j]) {
                        dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                        dp[i][1] = -1;
                    }
                } else if(dp[j][1] == 1){
                    if(nums[i] < nums[j]) {
                        dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                        dp[i][1] = -1;
                    }
                } else {
                    if(nums[i] > nums[j]) {
                        dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                        dp[i][1] = 1;
                    }
                }
            }
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}
