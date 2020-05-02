package robert.li.bsolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020/5/2
 */
public class B_3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        B_3_lengthOfLongestSubstring b_3_lengthOfLongestSubstring = new B_3_lengthOfLongestSubstring();
        int i = b_3_lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char eChar = chars[i];
            if (map.getOrDefault(eChar, 0) == 0) {
                map.put(eChar, 1);
                res = Math.max(res, i - start + 1);
            } else {
                map.put(eChar, map.get(eChar) + 1);
                while (map.get(eChar) != 1) {
                    char sChar = chars[start];
                    map.put(sChar, map.get(sChar) - 1);
                    start++;
                }
            }
        }
        return res;
    }
}
