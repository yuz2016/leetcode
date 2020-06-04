package robert.li.bsolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-23
 */
public class B_76_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        B_76_minWindow b_76_minWindow = new B_76_minWindow();
        String s1 = b_76_minWindow.minWindow(s, t);
        System.out.println(s1);
    }

    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < tChars.length; i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        int count = 0;
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(j < sChars.length) {
            if(!tMap.containsKey(sChars[j])) {
                j++;
            } else {
                Integer tmp = sMap.getOrDefault(sChars[j], 0) + 1;
                sMap.put(sChars[j], tmp);
                if(tmp.equals(tMap.get(sChars[j]))) {
                    count++;
                    if(count == tMap.size()) {
                        if(j - i + 1 < res) {
                            res = j - i + 1;
                            start = i;
                            end = j;
                        }
                        while(count == tMap.size()) {
                            if(!tMap.containsKey(sChars[i])) {
                                i++;
                            } else {
                                Integer num = sMap.get(sChars[i]) - 1;
                                sMap.put(sChars[i], num);
                                if(num.equals(tMap.get(sChars[i]) - 1)) {
                                    count--;
                                    if(j - i + 1 < res) {
                                        res = j - i + 1;
                                        start = i;
                                        end = j;
                                    }
                                }
                                i++;
                            }
                        }
                    }
                }
                j++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
}
