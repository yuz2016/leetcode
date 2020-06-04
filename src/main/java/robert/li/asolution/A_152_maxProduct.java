package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-18
 */
public class A_152_maxProduct {

    public int maxProduct2(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i; j < nums.length; j++) {
                tmp = tmp * nums[j];
                res = Math.max(res, tmp);
            }
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];// 最小值
        dp[0][1] = nums[0];// 最大值
        int res = Integer.MIN_VALUE;
        res = Math.max(res, dp[0][1]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }


}
