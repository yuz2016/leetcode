package robert.li.bsolution;

public class B_122_maxProfit {
    public int maxProfit(int[] prices) {
        int[] in = new int[prices.length];
        int[] out = new int[prices.length];
        in[0] = -prices[0];
        out[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            in[i] = Math.max(in[i - 1], out[i - 1] - prices[i]);
            out[i] = Math.max(in[i - 1] + prices[i], out[i - 1]);
        }
        return out[prices.length - 1];
    }
}
