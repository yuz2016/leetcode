package robert.li;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-19
 */
public class A_435_eraseOverlapIntervals {

    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 即：找到最大数量的互不重叠的区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    int intervalSchedule(int[][] intervals) {
        if(intervals.length == 0) return 0;
        // 按end对区间进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int cur = 0;
        // 遍历所有区间
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= intervals[cur][1]) {
                count++;
                cur = i;
            }
        }
        return count;
    }
}
