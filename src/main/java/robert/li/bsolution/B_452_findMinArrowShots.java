package robert.li.bsolution;

import java.util.Arrays;
import java.util.Comparator;

public class B_452_findMinArrowShots {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        B_452_findMinArrowShots b_452_findMinArrowShots = new B_452_findMinArrowShots();
        int minArrowShots = b_452_findMinArrowShots.findMinArrowShots(arr);
        int i = 0;
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int length = points.length;
        int i = 0;
        int res = 0;
        while(i < length) {
            int end = points[i][1];
            i++;
            while(i < length && points[i][0] <= end) {
                i++;
            }
            res++;
        }
        return res;
    }
}
