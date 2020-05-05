package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/30
 */
public class A_932_BeautifulArray {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer re : res) {
                if (re * 2 - 1 <= N) {
                    tmp.add(re * 2 - 1);
                }
            }
            for (Integer re : res) {
                if (re * 2 <= N) {
                    tmp.add(re * 2);
                }
            }
            res = tmp;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
