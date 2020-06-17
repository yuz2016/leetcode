package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-17
 */
public class A_1014_maxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] a) {
        if(a.length == 0) return 0;
        int max = a[0];
        int res = 0;
        for (int i = 1; i < a.length; i++) {
            max = max - 1;
            res = Math.max(res, max + a[i]);
            max = Math.max(max, a[i]);
        }
        return res;
    }
}
