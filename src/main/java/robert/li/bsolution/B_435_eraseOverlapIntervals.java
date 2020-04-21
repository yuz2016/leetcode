package robert.li.bsolution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-18
 */
public class B_435_eraseOverlapIntervals {


    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cur = 0;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            if(start < intervals[cur][1]) {
                res++;
            } else {
                cur = i;
            }
        }
        return res;
    }
}
