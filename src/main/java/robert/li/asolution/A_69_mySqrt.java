package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-09
 */
public class A_69_mySqrt {
    public static void main(String[] args) {
        A_69_mySqrt a_69_mySqrt = new A_69_mySqrt();
        int i = a_69_mySqrt.mySqrt1(4);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        long tar = x;
        long i = 1;
        long i2 = 1;
        while(i2 <= x) {
            i++;
            i2 = i * i;
        }
        return (int)(i - 1);
    }

    // 二分法
    public int mySqrt1(int x) {
        long left = 0;
        long right = x/2 + 1;
        while(left < right) {
            long mid = (left + right + 1) >>> 1;
            long r = mid * mid;
            if(r > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)(left);
    }
}
