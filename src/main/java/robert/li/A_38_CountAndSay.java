package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/22
 */
public class A_38_CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));

    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String n1 = countAndSay(n - 1);
        char[] n1Arr = n1.toCharArray();

        String res = "";

        int t = 0;
        for (int i = 0; i < n1Arr.length; i++) {
            t++;
            if (i == n1Arr.length - 1 || n1Arr[i] != n1Arr[i + 1]) {
                res = res.concat(String.valueOf(t)).concat(String.valueOf(n1Arr[i]));
                t = 0;
            }
        }
        return res;
    }
}
