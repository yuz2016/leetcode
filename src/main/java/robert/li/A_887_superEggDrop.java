package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-11
 */
public class A_887_superEggDrop {
    int[][] memo;

    public static void main(String[] args) {
        A_887_superEggDrop a = new A_887_superEggDrop();
        int i = a.superEggDrop(2, 6);
        System.out.println(i);
    }

    public int superEggDrop(int K, int N) {
        memo = new int[K + 1][N + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(K, N);
    }

    int dp(int K, int N) {
        if (memo[K][N] != -1)
            return memo[K][N];
        if (K == 1) {
            //            System.out.println("k:" + K + " n:" + N + " res:" + N);
            return N;
        }
        if (N == 0) {
            //            System.out.println("k:" + K + " n:" + N + " res:" + "0");
            return 0;
        }
        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= N; i++) {
//            res = Math.min(res, Math.max(dp(K - 1, i - 1), dp(K, N - i)) + 1);
//        }
        int lo = 1, hi = N;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int broken = dp(K - 1, mid - 1);
            int not_broken = dp(K, N - mid);
            if(not_broken > broken) {
                lo = mid + 1;
                res = Math.min(res, not_broken + 1);
            } else {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            }
        }
        memo[K][N] = res;
        //        System.out.println("k:" + K + " n:" + N + " res:" + res);
        return res;
    }
}
