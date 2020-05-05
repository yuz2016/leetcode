package robert.li.asolution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-16
 */
public class M_0106_compressString {

    public String compressString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(n == 0) {
            return "";
        }
        int count = 1;
        List<Character> charList = new LinkedList<>();
        List<Integer> intList = new LinkedList<>();
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i - 1]) {
                count++;
            } else {
                charList.add(chars[i - 1]);
                intList.add(count);
                count = 1;
            }
        }
        charList.add(chars[n - 1]);
        intList.add(count);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < charList.size(); i++) {
            res.append(charList.get(i)).append(intList.get(i));
        }
        return res.length() < n ? res.toString() : s;
    }
}
