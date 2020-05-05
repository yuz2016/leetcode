package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-03
 */
public class B_53_maxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        int res = Integer.MIN_VALUE;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = preSum + nums[i];
            if(pre < nums[i]) {
                preSum = nums[i];
            } else {
                preSum = pre;
            }
            res = Math.max(res, preSum);
        }
        return res;
    }
}
