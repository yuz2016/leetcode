package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;

public class A_205_isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        if(chars.length != chart.length) {
            return false;
        }
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(!maps.containsKey(chars[i])) {
                if(mapt.containsKey(chart[i])) {
                    if(mapt.get(chart[i]) != chars[i]) {
                        return false;
                    }
                }
                maps.put(chars[i], chart[i]);
                mapt.put(chart[i], chars[i]);
            } else {
                if(maps.get(chars[i]) != chart[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
