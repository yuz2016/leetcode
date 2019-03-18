package robert.li;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/23
 */
public class A_961_RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if(!set.add(A[i])) {
                return A[i];
            }
        }
        return 0;
    }
}
