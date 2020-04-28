package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-28
 */
public class A_494_findTargetSumWays {
    public static void main(String[] args) {
        int[] ints = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        A_494_findTargetSumWays a_494_findTargetSumWays = new A_494_findTargetSumWays();
//        int targetSumWays = a_494_findTargetSumWays.findTargetSumWays(ints, 1);
        int targetSumWays = a_494_findTargetSumWays.findTargetSumWays(ints, 1);
        System.out.println(targetSumWays);
    }
    public int findTargetSumWays(int[] nums, int S) {
        int sum = sumNums(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int count = (sum + S) / 2;
        int m = nums.length;
        int n = count;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    private int sumNums(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int findTargetSumWays1(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
