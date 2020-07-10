package robert.li.asolution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class M_1713_respace {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int length = sentence.length();
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if(set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[length];
    }
}
