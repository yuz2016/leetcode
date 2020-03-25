package robert.li;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-24
 */
public class A_464_canIWin {
    Map<String, Boolean> map;
    boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal)
            return false;
        if (desiredTotal <= 0)
            return true;
        map = new HashMap<>();
        used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal);
    }

    // 剩余累计和 desiredTotal，先手玩家 输赢结果
    public boolean helper(int desiredTotal) {
        // 先手选择时 desiredTotal<=0 已经输了
        if (desiredTotal <= 0)
            return false;
        String key = Arrays.toString(used);
        if (!map.containsKey(key)) {
            // try every unchosen number as next step
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    // check whether this lead to a win (i.e. the other player lose)
                    if (!helper(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
}
