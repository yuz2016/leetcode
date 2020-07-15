package robert.li.bsolution;

import java.util.Arrays;
import java.util.List;

public class B_120_minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int tmp = Integer.MAX_VALUE;
                if(j - 1 >= 0) {
                    tmp = triangle.get(i).get(j) + dp[j - 1];
                }
                if(j < triangle.get(i).size() - 1) {
                    tmp = Math.min(tmp, dp[j] + triangle.get(i).get(j));
                }
                dp[j] = tmp;
                if(i == size - 1) {
                    res = Math.min(res, tmp);
                }
            }
        }
        return size == 1 ? dp[0] : res;
    }
}
