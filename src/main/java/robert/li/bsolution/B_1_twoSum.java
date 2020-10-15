package robert.li.bsolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-03
 */
public class B_1_twoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(target - nums[i], i);
        }
        return res;
    }
}
