package robert.li.asolution;

public class A_97_isInterleave {
    public static void main(String[] args) {
        A_97_isInterleave a_97_isInterleave = new A_97_isInterleave();
        boolean interleave = a_97_isInterleave.isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac");
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
        return helper(s1, s2, s3, 0, 0, 0, dp);
    }

    boolean helper(String s1, String s2, String s3, int i1, int i2, int i3, int[][][] dp) {
        if(i1 == s1.length()) return s2.substring(i2).equals(s3.substring(i3));
        if(i2 == s2.length()) return s1.substring(i1).equals(s3.substring(i3));
        if (dp[i1][i2][i3] != 0) return dp[i1][i2][i3] == 1;
        boolean b;
        if (i1 < s1.length() && i2 < s2.length() && s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i1) == s3.charAt(i3)) {
            b = helper(s1, s2, s3, i1 + 1, i2, i3 + 1, dp) ||
                    helper(s1, s2, s3, i1, i2 + 1, i3 + 1, dp);
        } else if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            b = helper(s1, s2, s3, i1 + 1, i2, i3 + 1, dp);
        } else if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            b = helper(s1, s2, s3, i1, i2 + 1, i3 + 1, dp);
        } else {
            b = false;
        }
        dp[i1][i2][i3] = b ? 1 : -1;
        return b;
    }
}
