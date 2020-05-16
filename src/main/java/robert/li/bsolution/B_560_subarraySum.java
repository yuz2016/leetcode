package robert.li.bsolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-15
 */
public class B_560_subarraySum {
    public static void main(String[] args) {
        B_560_subarraySum b_560_subarraySum = new B_560_subarraySum();
        int i = b_560_subarraySum.subarraySum(new int[]{1, 1, 1}, 2);
    }

    public int subarraySum1(int[] nums, int k) {
        int sum = nums[0];
        int i = 0;
        int j = 0;
        int n = nums.length;
        int res = 0;
        while (i < n && j < n) {
            if (sum < k) {
                j++;
                if (j < n) {
                    sum += nums[j];
                }
            } else if (sum > k) {
                sum -= nums[i];
                i++;
            } else {
                res++;
                sum -= nums[i];
                i++;
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            if (dp[i][i] == k) res++;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] == k) res++;
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
