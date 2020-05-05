package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-21
 */
public class A_1248_numberOfSubarrays {

    /**
     * i...first...last...j
     *
     * res += (first - i + 1) * (j - last + 1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        int n = nums.length;
        int last = 0;
        for (int x = 0; x < n; x++) {
            if(isOdd(nums[x])) {
                if(!deque.isEmpty()) {
                    last = deque.peekLast();
                }
                deque.addLast(x);
            }
            if(deque.size() == k + 1) {
                j = x - 1;
                Integer first = deque.peekFirst();
                res += (first - i + 1) * (j - last + 1);
                i = first + 1;
                deque.pollFirst();
            }
        }

        if(deque.size() == k) {
            j = n - 1;
            Integer first = deque.peekFirst();
            last = deque.peekLast();
            res += (first - i + 1) * (j - last + 1);
        }
        return res;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
