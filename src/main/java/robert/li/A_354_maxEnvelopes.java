package robert.li;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/3/21
 */
public class A_354_maxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // 先排序 在 求最长上升子序列
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0 , len, envelope[1]);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }
}
