package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-19
 */
public class A_409_longestPalindrome {

    public int longestPalindrome(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        // 统计到map
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        // 计算有多少个奇数 oddNum
        int oddNum = 0;
        for (Character character : map.keySet()) {
            Integer count = map.get(character);
            if(count % 2 != 0) oddNum++;
        }
        // 结果为 s.length - oddNum + 1
        if(oddNum == 0) {
            return s.length();
        }
        return s.length() - oddNum + 1;
    }
}
