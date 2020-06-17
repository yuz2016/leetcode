package robert.li.bsolution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-12
 */
public class C_15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) continue;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0) {
                    Integer[] tmp = new Integer[]{nums[i], nums[start], nums[end]};
                    res.add(Arrays.asList(tmp));
                    do {
                        start++;
                    }
                    while(start < end && nums[start] == nums[start - 1]);
                } else if(sum < 0) {
                    do {
                        start++;
                    }
                    while(start < end && nums[start] == nums[start - 1]);
                } else {
                    do {
                        end--;
                    }
                    while(start < end && nums[end] == nums[end + 1]);
                }
            }
        }
        return res;
    }
}
