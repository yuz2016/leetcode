package robert.li;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-12
 */
public class A_438_findAnagrams {
    public List<Integer> findAnagrams(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int left = 0, right = 0;
        Map<Character, Integer> mapWindow = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < charsT.length; i++) {
            mapT.put(charsT[i], mapT.getOrDefault(charsT[i], 0) + 1);
        }
        int match = 0;
        List<Integer> res = new LinkedList<>();
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
                if(right - left == t.length()) {
                    res.add(left);
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
        return res;
    }

    public static void main(String[] args) {
        String a = "cbaebabacd";
        String b = "abc";
        A_438_findAnagrams a_438_findAnagrams = new A_438_findAnagrams();
        List res = a_438_findAnagrams.findAnagrams(a,b);
        System.out.println(1);
    }
}
