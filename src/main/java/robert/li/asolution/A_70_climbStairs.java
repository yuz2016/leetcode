package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-09
 */
public class A_70_climbStairs {
    public int climbStairs(int n) {
        int i_2 = 1;
        int i_1 = 2;
        if(n <= 2) return n;
        int cur = 0;
        for(int i = 3; i <= n ;i++) {
            cur = i_1 + i_2;
            i_2 = i_1;
            i_1 = cur;
        }
        return cur;
    }
}
