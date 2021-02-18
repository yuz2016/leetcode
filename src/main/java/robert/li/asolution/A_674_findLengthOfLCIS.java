package robert.li.asolution;

public class A_674_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 1) return 0;
        int curMaxLength = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                curMaxLength = curMaxLength + 1;
                res = Math.max(curMaxLength, res);
            } else {
                curMaxLength = 1;
            }
        }
        return res;
    }
}
