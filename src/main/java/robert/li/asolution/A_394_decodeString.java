package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-28
 */
public class A_394_decodeString {
    public static void main(String[] args) {
        A_394_decodeString a_394_decodeString = new A_394_decodeString();
        String s = a_394_decodeString.decodeString("100[leetcode]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int left = 0;
        int right = 0;
        int leftCount = 0;
        while(i < s.length() && j < s.length()) {
            if(isNumber(s.charAt(i))) {
                while(isNumber(s.charAt(j))) {
                    j++;
                }
                int count = Integer.parseInt(s.substring(i, j));
                left = j;
                leftCount++;
                j = j + 1;
                while(leftCount > 0) {
                    if(s.charAt(j) == '[') {
                        leftCount++;
                    } else if(s.charAt(j) == ']'){
                        leftCount--;
                    }
                    j++;
                }
                right = j - 1;
                i = j;
                String substring = s.substring(left + 1, right);
                while(count > 0) {
                    sb.append(decodeString(substring));
                    count--;
                }
            } else {
                while(i < s.length() && j < s.length() && !isNumber(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                    j++;
                }
            }
        }
        return sb.toString();
    }

    boolean isNumber(char c) {
        return c - '0' >= 0 && c - '0' < 10;
    }
}
