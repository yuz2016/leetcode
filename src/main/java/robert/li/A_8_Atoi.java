package robert.li;

import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/23
 */
public class A_8_Atoi {

    public static void main(String[] args) {

        A_8_Atoi atoi = new A_8_Atoi();
        int i = atoi.myAtoi2("-91283472332");
        int r = 0;
    }

    /**
     * 无法解决越界问题
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        char[] strArr = str.toCharArray();
        List list = Arrays.asList('-', '+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        int start = 0;

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == ' ' && i != strArr.length - 1) {
                continue;
            }
            if (strArr[i] == ' ' && i == strArr.length - 1) {
                return 0;
            }

            if (list.contains(strArr[i])) {
                start = i;
                break;
            }
            return 0;
        }

        int end = 0;

        for (int i = start; i < strArr.length; i++) {
            if (!list.contains(strArr[i])) {
                end = i;
                break;
            }

            if (list.contains(strArr[i]) && i == strArr.length - 1) {
                end = strArr.length;
            }
        }

        char[] charsInt = Arrays.copyOfRange(strArr, start, end);

        String s = new String(charsInt);

        return Integer.parseInt(s);

    }

    public int myAtoi2(String str) {
        int index = 0, sign = 1;
        long sum = 0;
        //1. Empty string
        if (str.length() == 0 || str == null) {
            return 0;
        }

        //2. Remove Spaces
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        //3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4.convert use long
        for (int i = index; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign > 0 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign < 0 && sum * -1 < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) sum * sign;

    }

}
