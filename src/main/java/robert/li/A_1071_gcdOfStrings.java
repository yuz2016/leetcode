package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-12
 */
public class A_1071_gcdOfStrings {

    // 辗转相除 a 和b 的最大公约数 等于 b 和 a%b余数 的最大公约数
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    int gcd(int a, int b) {
        return b == 0? a : gcd(b, a%b);
    }
}
