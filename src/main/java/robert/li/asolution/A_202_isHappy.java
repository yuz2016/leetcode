package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-30
 */
public class A_202_isHappy {
    public boolean isHappy(int n) {
        int one = n;
        int two = n;
        do {
            one = intSquareNum(one);
            two = intSquareNum(intSquareNum(two));
        } while(one != two);
        return one == 1;
    }

    int intSquareNum(int num) {
        int res = 0;
        while(num != 0) {
            int tmp = num % 10;
            num = num / 10;
            res += tmp * tmp;
        }
        return res;
    }
}
