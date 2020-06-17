package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-06
 */
public class A_128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            Integer left = map.getOrDefault(nums[i] - 1, 0);
            Integer right = map.getOrDefault(nums[i] + 1, 0);
            int cur = left + 1 + right;
            map.put(nums[i], cur);
            if(left != 0) {
                map.put(nums[i] - left, cur);
            }
            if(right != 0) {
                map.put(nums[i] + right, cur);
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
