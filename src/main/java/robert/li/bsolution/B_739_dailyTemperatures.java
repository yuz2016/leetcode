package robert.li.bsolution;

import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-11
 */
public class B_739_dailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] res = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (t[i] >= stack.peek()) {
                    stack.pop();
                } else {
                    break;
                }
            }
            int index = stack.isEmpty() ? -1 : stack.peek();
            if(index == -1) {
                res[i] = 0;
            } else {
                res[i] = index - i;
            }
            stack.push(t[i]);
        }
        return res;
    }
}
