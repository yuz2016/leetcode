package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-27
 */
public class A_392_isSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(sChars[i] == tChars[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }
}
