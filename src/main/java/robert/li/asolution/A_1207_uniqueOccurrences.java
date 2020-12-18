package robert.li.asolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-28
 */
public class A_1207_uniqueOccurrences {
    public static void main(String[] args) {
        A_1207_uniqueOccurrences a_1207_uniqueOccurrences = new A_1207_uniqueOccurrences();
        a_1207_uniqueOccurrences.uniqueOccurrences(new int[]{1,2,2,1,1,3});
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if(set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }
        return true;
    }
}
