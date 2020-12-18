package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-11
 */
public class A_514_findRotateSteps {

    public int findRotateSteps(String ring, String key) {
        char[] rings = ring.toCharArray();
        char[] keys = key.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rings.length; i++) {
            if(map.containsKey(rings[i])) {
                map.get(rings[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(rings[i], list);
            }
        }
        int[][] dp = new int[ring.length()][key.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(rings, keys, 0, 0, map, dp) + key.length();
    }

    int dfs(char[] rings, char[] keys, int i, int j, Map<Character, List<Integer>> map, int[][] dp) {
        if(j == keys.length) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        List<Integer> list = map.get(keys[j]);
        for (Integer index : list) {
            int abs = Math.abs(index - i);
            int other = rings.length - abs;
            res = Math.min(res, Math.min(abs, other) + dfs(rings, keys, index, j + 1, map, dp));
        }
        dp[i][j] = res;
        return res;
    }
}
