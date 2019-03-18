package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/22
 */
public class A_14_LongestCommonPrefix {

    public static void main(String[] args) {
        String []test = new String[]{"aa","a"};
        System.out.println(longestCommonPrefix(test));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }
        char[] chars = strs[0].toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!innerFor(strs, chars[i], i)){
                break;
            }
            res++;
        }
        return String.valueOf(Arrays.copyOfRange(chars, 0, res));

    }

    private static boolean innerFor(String[] strs, char aChar, int i) {
        for (int i1 = 1; i1 < strs.length; i1++) {
            if(strs[i1].length() <= i ){
                return false;
            }
            if(strs[i1].toCharArray()[i] != aChar){
                return false;
            }
        }
        return true;
    }
}
