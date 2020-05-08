package robert.li.asolution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-08
 */
public class A_646_findLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int n = pairs.length;
        int[] cur = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] <= cur[1]) {
                n--;
            } else {
                cur = pairs[i];
            }
        }
        return n;
    }
}
