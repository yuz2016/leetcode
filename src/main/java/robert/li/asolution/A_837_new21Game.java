package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-03
 */
public class A_837_new21Game {
    public static void main(String[] args) {
        A_837_new21Game a_837_new21Game = new A_837_new21Game();
        double v = a_837_new21Game.new21Game(6, 1, 10);
        double s = 11 / 10;
    }


    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1;
        if (K == 1) return (double)Math.min(N, W) / (double)W;
        double[] dp = new double[N + 1]; // dp[i]分数到i的概率
        double[] sum = new double[N + 1];// 概率和
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            int left = Math.max(0, i - W);
            int right = Math.min(i - 1, K - 1);
            dp[i] = (double)(sum[right] - sum[left] + dp[left]) / (double)W;
            sum[i] = sum[i - 1] + dp[i];
        }
        return sum[N] - sum[K - 1];
    }
}
