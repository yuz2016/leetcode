package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-06
 */
public class M_57_findContinuousSequence {

    int size = 0;

    public static void main(String[] args) {
        M_57_findContinuousSequence m = new M_57_findContinuousSequence();
        int[][] continuousSequence = m.findContinuousSequence(9);
        System.out.println(1);
    }

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2;
        int sum = i + j;
        List<int[]> res = new ArrayList<>();
        while (j > i) {
            if (sum < target) {
                sum += j + 1;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] temp = new int[j - i + 1];
                int t = i;
                for(int a = 0;a < temp.length;a++){
                    temp[a] = t++;
                }
                res.add(temp);
                sum += j + 1;
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
