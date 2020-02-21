package robert.li;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-19
 */
public class A_452_findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        // 按end对区间进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int cur = 0;
        // 遍历所有区间
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > points[cur][1]) {
                count++;
                cur = i;
            }
        }
        return count;
    }
}
