package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-11
 */
public class A_76_minWindow {
    public String minWindow(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int left = 0, right = 0;
        Map<Character, Integer> mapWindow = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < charsT.length; i++) {
            mapT.put(charsT[i], mapT.getOrDefault(charsT[i], 0) + 1);
        }
        int match = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < charsS.length) {
            //  maps 添加 right++
            mapWindow.put(charsS[right], mapWindow.getOrDefault(charsS[right],0) + 1);
            // 更新match
            if(mapWindow.get(charsS[right]).equals(mapT.get(charsS[right]))) {
                match++;
            }
            right++;

            while(match == mapT.size()) {
                // 更新res索引和长度
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 更新match
                if(mapWindow.get(charsS[left]).equals(mapT.get(charsS[left]))) {
                    match--;
                }
                // left++ maps 移除
                mapWindow.put(charsS[left], mapWindow.get(charsS[left]) - 1);
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? null : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "ABC";
        A_76_minWindow a_76_minWindow = new A_76_minWindow();
        String res = a_76_minWindow.minWindow(a,b);
        System.out.println(1);
    }
}
