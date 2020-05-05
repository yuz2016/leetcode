package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-13
 */
public class A_746_minCostClimbingStairs {

    public static void main(String[] args) {
        A_746_minCostClimbingStairs a = new A_746_minCostClimbingStairs();
        int i = a.minCostClimbingStairs(new int[] { 10, 15, 20 });
        System.out.println(i);
        int j = a.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
        System.out.println(j);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2)
            return Math.min(cost[0], cost[1]);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
