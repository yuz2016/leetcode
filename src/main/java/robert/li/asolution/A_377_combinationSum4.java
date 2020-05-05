package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-13
 */
public class A_377_combinationSum4 {

    public static void main(String[] args) {
        A_377_combinationSum4 a_377_combinationSum4 = new A_377_combinationSum4();
        int i = a_377_combinationSum4.combinationSum4(new int[] { 1, 2, 3 }, 4);
        System.out.println("i: " + i);
    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] <= i) {
                    sum += dp[i - nums[j]];
                }
            }
            dp[i] = sum;
        }
        return dp[target];
    }
}
