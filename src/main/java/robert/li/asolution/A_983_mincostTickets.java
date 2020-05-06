package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-06
 */
public class A_983_mincostTickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {7, 2, 15};
        A_983_mincostTickets a_983_mincostTickets = new A_983_mincostTickets();
        int i = a_983_mincostTickets.mincostTickets(days, costs);
        System.out.println(i);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] seven = new int[n];
        int[] thirty = new int[n];
        Arrays.fill(seven, -1);
        Arrays.fill(thirty, -1);
        for (int i = 0; i < days.length; i++) {
            int day = days[i];
            int sevenDay = day + 7;
            int thirtyDay = day + 30;
            for (int j = 1; j < days.length; j++) {
                if (seven[i] == -1 && days[j] >= sevenDay) {
                    seven[i] = j;
                }
                if (thirty[i] == -1 && days[j] >= thirtyDay) {
                    thirty[i] = j;
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, n * costs[0]);
        dp[n - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = dp.length - 2; i >= 0; i--) {
            if (seven[i] != -1) {
                dp[i] = Math.min(dp[i], costs[1] + dp[seven[i]]);
            } else {
                dp[i] = Math.min(dp[i], costs[1]);
            }
            if (thirty[i] != -1) {
                dp[i] = Math.min(dp[i], costs[2] + dp[thirty[i]]);
            } else {
                dp[i] = Math.min(dp[i], costs[2]);
            }
            dp[i] = Math.min(dp[i], costs[0] + dp[i + 1]);
        }
        return dp[0];
    }

    // dp 是天数 非days的index
    public int mincostTickets1(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制  0 -> maxDay + 31
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }
}
