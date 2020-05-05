package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-12
 */
public class A_3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int right = 0, left = 0;
        while(right < chars.length) {
            char r = chars[right];
            map.put(r, map.getOrDefault(r, 0) + 1);
            right++;
            while(map.get(r) > 1) {
                char l = chars[left];
                map.put(l, map.get(l) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
