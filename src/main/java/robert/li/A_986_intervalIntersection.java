package robert.li;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-18
 */
public class A_986_intervalIntersection {

    public int[][] intervalIntersection(int[][] a, int[][] b) {
        int i = 0,j = 0;
        List<int[]> list = new LinkedList<>();
        while(i < a.length && j < b.length) {
            int a1 = a[i][0];
            int a2 = a[i][1];
            int b1 = b[j][0];
            int b2 = b[j][1];
            if(b2 >= a1 && b1 <= a2) {
                int start = Math.max(a1, b1);
                int end = Math.min(a2, b2);
                list.add(new int[]{start, end});
            }
            if(b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        return list.toArray(new int[0][]);
    }
}
