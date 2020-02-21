package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-21
 */
public class A_714_maxProfit {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0) return 0;
        int a0 = 0, a1 = -prices[0];
        for(int i = 1; i < prices.length;i++) {
            a0 = Math.max(a0, a1 + prices[i] - fee);
            a1 = Math.max(a1, a0 - prices[i]);
        }
        return a0;
    }
}
