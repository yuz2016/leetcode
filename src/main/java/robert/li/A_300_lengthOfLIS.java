package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/12
 */
public class A_300_lengthOfLIS {

    /**
     * Approach #1 Brute Force [Time Limit Exceeded]
     * <p>
     * 最简单的方法是尝试找到所有增加的子序列，然后返回最长增长子序列的最大长度。
     * 为了做到这一点，我们使用一个递归函数lengthofLISlengthofLIS，
     * 它从当前元素（对应于curposcurpos）开始返回LIS的长度（包括当前元素）。在每个函数调用中，我们考虑两种情况：
     * <p>
     * 当前元素大于LIS中包含的前一个元素。在这种情况下，我们可以在LIS中包含当前元素。
     * 因此，我们通过包含它来找出获得的LIS的长度。
     * 此外，我们还通过不包括LIS中的当前元素来找出LIS的长度。
     * 因此，当前函数调用返回的值是两个长度中的最大值。
     * <p>
     * 当前元素小于LIS中包含的前一个元素。在这种情况下，我们不能在LIS中包含当前元素。
     * 因此，我们通过不包括当前函数调用返回的LIS中的当前元素，仅发现LIS的长度。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS0(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    /**
     * Approach #2 Recursion with memorization [Memory Limit Exceeded]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int memo[][] = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthofLIS(nums, -1, 0, memo);
    }

    public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
        if (curpos == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][curpos] >= 0) {
            return memo[previndex + 1][curpos];
        }
        int taken = 0;
        if (previndex < 0 || nums[curpos] > nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }

    /**
     * Approach #3 Dynamic Programming [Accepted]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * Approach #4 Dynamic Programming with Binary Search[Accepted]
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
