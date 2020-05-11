package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-11
 */
public class A_50_myPow {
    public static void main(String[] args) {
        A_50_myPow a_50_myPow = new A_50_myPow();
        double v = a_50_myPow.myPow(2, 10);
        System.out.println(v);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-1 * Integer.MIN_VALUE);
        double v1 = a_50_myPow.myPow1(2, Integer.MIN_VALUE);
    }

    public double myPow(double x, int n) {
        return helper(x, n);
    }

    double helper(double x, long n) {
        if (n == 0) return 1;
        double res = 1;
        if (n > 0) {
            if (n % 2 == 0) {
                double d = helper(x, n / 2);
                res = d * d;
            } else {
                double d = helper(x, n / 2);
                res = x * d * d;
            }
        } else {
            double d = helper(x, -n);
            res = 1 / d;
        }
        return res;
    }


    public double myPow1(double x, int n) {
        if (n == 0)
            return 1;

        boolean positive = true;
        if (n < 0) {
            positive = false;
            n = n * -1;
        }

        double res = 1;
        if (n % 2 == 1) {
            double half = myPow1(x, n / 2);
            res = res * half * half * x;
        } else {
            double half = myPow1(x, n / 2);
            res = res * half * half;
        }

        return positive ? res : 1 / res;
    }


}
