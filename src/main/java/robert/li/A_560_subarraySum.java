package robert.li;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-12
 */
public class A_560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        int res = 0, sum0_i = 0;
        // 前缀和-》前缀和出现次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum0_i = sum0_i + nums[i];
            int sum0_j = sum0_i - k;
            if(map.containsKey(sum0_j)) {
                res = res + map.get(sum0_j);
            }
            map.put(sum0_i, map.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
