package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-21
 */
public class A_309_maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int a0 = 0, a1 = -prices[0];
        int ai_0 = 0;
        for(int i = 1; i < prices.length;i++) {
            int tmp = a0;
            if(i > 1) {
                a0 = Math.max(a0, a1 + prices[i]);
                a1 = Math.max(a1, ai_0 - prices[i]);
            } else {
                a0 = Math.max(a0, a1 + prices[i]);
                a1 = Math.max(a1, a0 - prices[i]);
            }
            ai_0 = tmp;

        }
        return a0;
    }
}
