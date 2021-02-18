package robert.li.bsolution;

import java.util.Arrays;

public class C_435_eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int index = 0;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= intervals[index][1]) {
                index = i;
            } else {
                res++;
            }
        }
        return res;
    }
}
