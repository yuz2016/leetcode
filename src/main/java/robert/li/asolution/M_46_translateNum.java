package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-09
 */
public class M_46_translateNum {
    Map<String, Integer> map = new HashMap<>();
    public int translateNum(int num) {
        String s = String.valueOf(num);
        return helper(s);
    }

    int helper(String s) {
        if(s.length() < 2) return 1;
        if(map.containsKey(s)) {
            return map.get(s);
        }
        String one = s.substring(0, 1);
        String two = s.substring(0, 2);
        int oneCount = helper(s.substring(1));
        int i = Integer.parseInt(two);
        int twoCount = 0;
        if(!one.equals("0") && i <= 25) {
            twoCount = helper(s.substring(2));
        }
        int sum = oneCount + twoCount;
        map.put(s, sum);
        return sum;
    }
}
