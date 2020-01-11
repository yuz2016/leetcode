package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-07
 */
public class A_96_numTrees {
    public int numTrees(int n) {
        if(n < 1) {
            return 0;
        }
        return helper(1, n);
    }

    int helper(int start, int end) {
        if(start > end) {
            return 1;
        }
        int res = 0;
        for(int i = start; i <= end; i++) {
            int left = helper(start, i - 1);
            int right = helper(i + 1, end);
            res += left * right;
        }
        return res;
    }

    public class Solution {
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }
}
