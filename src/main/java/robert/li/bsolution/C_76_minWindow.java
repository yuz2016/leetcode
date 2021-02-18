package robert.li.bsolution;

import java.util.HashMap;
import java.util.Map;

public class C_76_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t =
                "ABC";
        C_76_minWindow c_76_minWindow = new C_76_minWindow();
        c_76_minWindow.minWindow(s, t);
    }

    public String minWindow(String s, String t) {
        // 统计t 字符 次数
        char[] charsT = t.toCharArray();
        char[] charsS = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charsT.length; i++) {
            map.put(charsT[i], map.getOrDefault(charsT[i], 0) + 1);
        }
        int length = charsT.length;
        int curLength = 0;
        int left = 0;
        int right = 0;
        int res = 100000;
        int resLeft = -1;
        int resRight = -1;

        while (right < charsS.length) {
            if (map.containsKey(charsS[right])) {
                map.put(charsS[right], map.get(charsS[right]) - 1);
                if (map.get(charsS[right]) >= 0) {
                    curLength++;
                }
            }
            while (curLength == length) {
                if (res > right - left + 1) {
                    res = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }
                if (map.containsKey(charsS[left])) {
                    map.put(charsS[left], map.get(charsS[left]) + 1);
                    if (map.get(charsS[left]) > 0) {
                        curLength--;
                    }
                }
                left++;
            }
            right++;
        }
        return resLeft == -1 && resRight == -1 ? "" : s.substring(resLeft, resRight + 1);
    }
}
