package robert.li.bsolution;

public class D_121_maxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if(prices[i] > min) {
                res = Math.max(prices[i] - min, res);
            }
        }
        return res;
    }
}
