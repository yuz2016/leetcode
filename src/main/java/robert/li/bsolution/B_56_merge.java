package robert.li.bsolution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-16
 */
public class B_56_merge {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(curStart <= end) {
                end = Math.max(end, curEnd);
            } else {
                list.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}
