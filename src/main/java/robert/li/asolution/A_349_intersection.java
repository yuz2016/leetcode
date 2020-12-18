package robert.li.asolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-02
 */
public class A_349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, true);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if(map.containsKey(i)) {
                if(map.get(i)) {
                    list.add(i);
                    map.put(i, false);
                }
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
