package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

public class A_830_largeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if(s.length() < 3) return res;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i - 1]) {
                end = i;
            } else {
                if(end - start + 1 >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }
                start = end = i;
            }
        }
        if(end == chars.length - 1 && end - start + 1 >=3) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            res.add(list);
        }
        return res;
    }
}
