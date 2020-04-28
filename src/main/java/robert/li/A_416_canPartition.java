package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-28
 */
public class A_416_canPartition {

    public static void main(String[] args) {
        A_416_canPartition a_416_canPartition = new A_416_canPartition();
        boolean b = a_416_canPartition.canPartition(new int[] { 1, 5, 11, 5 });
        System.out.println(b);
    }
    public boolean canPartition(int[] nums) {
        int sum = sumNums(nums);
        if (sum % 2 != 0)
            return false;
        int m = nums.length;
        int n = sum / 2;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
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
}
