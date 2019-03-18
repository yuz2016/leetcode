package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/10
 */
public class A_322_coinChange {

    //    /**
    //     * backtrace
    //     *
    //     * @param coins
    //     * @param amount
    //     * @return
    //     */
    //    public int coinChange(int[] coins, int amount) {
    //        if (amount < 1) return 0;
    //        return coinChange(coins, amount, new int[amount]);
    //    }
    //
    //    private int coinChange(int[] coins, int rem, int[] count) {
    //        if (rem < 0) return -1;
    //        if (rem == 0) return 0;
    //        if (count[rem - 1] != 0) return count[rem - 1];
    //        int min = Integer.MAX_VALUE;
    //        for (int coin : coins) {
    //            int res = coinChange(coins, rem - coin, count);
    //            if (res >= 0 && res < min)
    //                min = 1 + res;
    //        }
    //        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    //        return count[rem - 1];
    //    }

    /**
     * dp
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
