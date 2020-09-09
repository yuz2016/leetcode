package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-01
 */
public class A_172_trailingZeroes {

    public static void main(String[] args) {
        A_172_trailingZeroes a_172_trailingZeroes = new A_172_trailingZeroes();
        int i = a_172_trailingZeroes.trailingZeroes(125);
        System.out.println(i);
    }

    int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

}
