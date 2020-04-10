package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-10
 */
public class A_151_reverseWords {

    public static void main(String[] args) {
        A_151_reverseWords a = new A_151_reverseWords();
        String the_sky_is_blue = a.reverseWords("   a   b  c d   e  ");
        System.out.println(the_sky_is_blue);
        String s = a.removeInnerBlank("te   te");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        String trim = s.trim();
        // 去除中间多余空格
        trim = removeInnerBlank(trim);
        int n = trim.length();
        int i = 0, j = 0;
        for (int x = 0; x < n; x++) {
            if (trim.charAt(x) == ' ') {
                j = x - 1;
                trim = reverseString(trim, i, j);
                i = x + 1;
            }

            if (x == n - 1) {
                trim = reverseString(trim, i, n - 1);
            }

        }
        return reverseString(trim, 0, n - 1);
    }

    String removeInnerBlank(String s) {
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if(start == -1 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                start = i;
            } else if(start != -1 && s.charAt(i) != ' ') {
                s = s.substring(0, start) + s.substring(i, s.length());
                i = start - 1;
                start = -1;
            }
        }
        return s;
    }

    String reverseString(String s, int i, int j) {
        char[] chars = s.toCharArray();
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
