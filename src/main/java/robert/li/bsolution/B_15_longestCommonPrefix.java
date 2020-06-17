package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-15
 */
public class B_15_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        if(strs.length == 0) return "";
        String str = strs[0];
        while(index < str.length()) {
            boolean b = isCommonPrefix(strs, index);
            if(!b) break;
            index++;
        }
        return str.substring(0, index);
    }

    private boolean isCommonPrefix(String[] strs, int index) {
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
