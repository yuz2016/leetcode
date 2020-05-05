package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/29
 */
public class A_53_maxSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}
