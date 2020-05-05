package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/23
 */
public class A_121_maxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = prices[i] < minPrice ? prices[i] : minPrice;
            profit = prices[i] - minPrice > profit ? prices[i] - minPrice : profit;
        }
        return profit;
    }
}
