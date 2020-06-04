package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-27
 */
public class A_974_subarraysDivByK {

    public static void main(String[] args) {
        A_974_subarraysDivByK a_974_subarraysDivByK = new A_974_subarraysDivByK();
        a_974_subarraysDivByK.subarraysDivByK(new int[]{2, -2, 2, -4}, 6);
    }

    public int subarraysDivByK(int[] a, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(k);
        // 初始 index = -1， 整出K = 0
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            int tmp = (sum % k + k) % k;
            int preCount = map.getOrDefault(tmp, 0);
            res += preCount;
            map.put(tmp, preCount + 1);
        }
        return res;
    }
}
