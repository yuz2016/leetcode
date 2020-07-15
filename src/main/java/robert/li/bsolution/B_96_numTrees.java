package robert.li.bsolution;

public class B_96_numTrees {
    public static void main(String[] args) {
        B_96_numTrees b_96_numTrees = new B_96_numTrees();
        int i = b_96_numTrees.numTrees(3);
        System.out.println(i);
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        int helper = helper(n, dp);
        return helper;
    }

    int helper(int n, int[] dp) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(dp[n] != 0) return dp[n];
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            int left = 1, right = 1;
            if(i - 1 > 0) {
                left = helper(i - 1, dp);
            }
            if(n - i > 0) {
                right = helper(n - i, dp);
            }
            tmp += left * right;
        }
        dp[n] = tmp;
        return dp[n];
    }
}
