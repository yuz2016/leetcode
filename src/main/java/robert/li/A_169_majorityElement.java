package robert.li;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-13
 */
public class A_169_majorityElement {

    Map<Integer, Integer> map = new HashMap<>();
    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        int key = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == key) {
                count++;
            } else {
                count--;
            }

            if(count <= 0) {
                key = nums[i + 1];
            }
        }
        return key;
    }


}
