package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-19
 */
public class B_125_isPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        String ss = s.toLowerCase();
        char[] chars = ss.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while(i < j) {
            while(i < j && !isNumOrCharacter(chars[i])) {
                i++;
            }
            while(i < j && !isNumOrCharacter(chars[j])) {
                j--;
            }
            if(i >= j) break;
            if(chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean isNumOrCharacter(char c) {
        if(c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        if(c - 'a' >= 0 && c - 'z' <= 25) {
            return true;
        }
        return false;
    }
}
