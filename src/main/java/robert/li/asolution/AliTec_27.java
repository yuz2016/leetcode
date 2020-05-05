package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-27
 */
public class AliTec_27 {

    int minNotSportDays(int[] a) {
        int n = a.length;
        return n - helper(a, 0, 0);
    }

    /**
     * @param a         开馆数组
     * @param i         当前在第几天
     * @param lastState 昨天的运动状态 0-没运动，1-滑冰，2-游泳
     * @return 运动最大天数
     */
    int helper(int[] a, int i, int lastState) {
        if (i >= a.length)
            return 0;
        int cur = a[i];
        if (cur == 0) {
            return helper(a, i + 1, 0);
        } else if (cur == 1) {
            if (lastState != 1) {
                return 1 + helper(a, i + 1, 1);
            } else {
                return helper(a, i + 1, 0);
            }
        } else if (cur == 2) {
            if (lastState != 2) {
                return 1 + helper(a, i + 1, 2);
            } else {
                return helper(a, i + 1, 0);
            }
        } else if (cur == 3) {
            if (lastState == 0) {
                return Math.max(helper(a, i + 1, 0), 1 + Math.max(helper(a, i + 1, 1), helper(a, i + 1, 2)));
            } else if (lastState == 1) {
                return Math.max(helper(a, i + 1, 0), 1 + helper(a, i + 1, 2));
            } else if (lastState == 2) {
                return Math.max(helper(a, i + 1, 0), 1 + helper(a, i + 1, 1));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        AliTec_27 a = new AliTec_27();
        int i = a.minNotSportDays(new int[] { 3,3,1,2,0});
        System.out.println("i:" + i);

    }
}
