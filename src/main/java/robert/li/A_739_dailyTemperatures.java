package robert.li;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-02
 */
public class A_739_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && T[i] >= T[s.peek()]) {
                s.pop();
            }

            res[i] = s.isEmpty()? 0 : s.peek() - i;
            s.push(i);
        }
        return res;
    }
}
