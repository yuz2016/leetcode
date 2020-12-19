package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

public class A_57_insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int min = newInterval[0];
        int max = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= max) {
            min = Math.min(intervals[i][0], min);
            max = Math.max(intervals[i][1], max);
            i++;
        }
        list.add(new int[]{min, max});
        while(i < intervals.length && intervals[i][0] > newInterval[1]) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int[][] res = new int[list.size()][2];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1][0] = list.get(i1)[0];
            res[i1][1] = list.get(i1)[1];
        }
        return res;
    }
}
