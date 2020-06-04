package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-20
 */
public class A_1371_findTheLongestSubstring {
    public static void main(String[] args) {
        A_1371_findTheLongestSubstring a_1371_findTheLongestSubstring = new A_1371_findTheLongestSubstring();
        int eleetminicoworoep = a_1371_findTheLongestSubstring.findTheLongestSubstring("leetcodeisgreat");
        System.out.println(eleetminicoworoep);

    }
    int[] arr = new int[32];

    public int findTheLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int tmp = 0;
        int res = 0;
        Arrays.fill(arr, -2);
        arr[0] = -1;
        for (int x = 0; x < chars.length; x++) {
            int bit = getBit(chars[x]);
            if(bit != -2) {
                tmp = tmp ^ bit;
            }
            if(arr[tmp] == -2) {
                arr[tmp] = x;
            } else {
                res = Math.max(res, x - arr[tmp]);
            }
        }
        return res;
    }

    int getBit(char c) {
        if(c == 'a') {
            return 16;
        }
        if(c == 'e') {
            return 8;
        }
        if(c == 'i') {
            return 4;
        }
        if(c == 'o') {
            return 2;
        }
        if(c == 'u') {
            return 1;
        }
        return -2;
    }
}
