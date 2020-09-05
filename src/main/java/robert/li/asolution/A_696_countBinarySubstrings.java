package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-08-10
 */
public class A_696_countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] != chars[i + 1]) {
                res++;
                int cur = 1;
                while(i - cur >= 0 && i + 1 + cur < chars.length && chars[i] == chars[i - cur] && chars[i + 1] == chars[i + 1 + cur]) {
                    res++;
                    cur++;
                }
            }
        }
        return res;
    }
}
