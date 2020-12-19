package robert.li.asolution;

import java.util.*;
import java.util.stream.Collectors;

public class A_49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String[] s = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String sortString = sortString(strs[i]);
            s[i] = sortString;
            if (map.containsKey(sortString)) {
                map.get(sortString).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sortString, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
