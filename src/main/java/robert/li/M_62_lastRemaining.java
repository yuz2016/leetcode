package robert.li;

import java.util.ArrayList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-30
 */
public class M_62_lastRemaining {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
