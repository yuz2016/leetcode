package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/23
 */
public class A_122_maxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit += prices[i + 1] - prices[i] > 0 ? prices[i + 1] - prices[i] : 0;
        }
        return profit;
    }
}
