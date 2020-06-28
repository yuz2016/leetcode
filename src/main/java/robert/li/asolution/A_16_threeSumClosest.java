package robert.li.asolution;

import java.util.Arrays;

public class A_16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == target) return target;
                if(sum < target) {
                    if(target - sum < diff) {
                        diff = target - sum;
                        res = sum;
                    }
                    start++;
                } else {
                    if(sum - target < diff) {
                        diff = sum - target;
                        res = sum;
                    }
                    end--;
                }
            }
        }
        return res;
    }
}
