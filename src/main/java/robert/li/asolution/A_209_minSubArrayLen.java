package robert.li.asolution;

public class A_209_minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, j = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while(j < nums.length) {
            if(sum < s) {
                j++;
                if(j < nums.length) {
                    sum += nums[j];
                }
            } else {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
