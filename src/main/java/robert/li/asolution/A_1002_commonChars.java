package robert.li.asolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-14
 */
public class A_1002_commonChars {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if(A.length < 2) return res;
        String s = A[0];
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            map = merge(map, A[i]);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            for (Integer i = 0; i < value; i++) {
                res.add("" + entry.getKey());
            }
        }
        return res;
    }

    Map<Character, Integer> merge(Map<Character, Integer> map, String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> res = new HashMap<>();
        for (char c : chars) {
            if(map.containsKey(c)) {
                Integer integer = map.get(c);
                if(integer == 1) {
                    map.remove(c);
                } else {
                    map.put(c, integer - 1);
                }
                res.put(c, res.getOrDefault(c, 0) + 1);
            }
        }
        return res;
    }
}
