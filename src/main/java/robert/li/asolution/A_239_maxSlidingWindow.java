package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-03
 */
public class A_239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        MQueue mQueue = new MQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if(i < k - 1) {
                mQueue.push(nums[i]);
            } else {
                mQueue.push(nums[i]);
                res[i - (k - 1)] = mQueue.max();
                mQueue.pop(nums[i - (k - 1)]);
            }
        }
        return res;
    }

}
class MQueue {
    Deque<Integer> deque = new LinkedList<>();
    void push(int n) {
        while(!deque.isEmpty() && deque.peekFirst() < n) {
            deque.pollFirst();
        }
        deque.offerFirst(n);
    }

    int max() {
        return deque.getLast();
    }

    void pop(int n) {
        if(!deque.isEmpty() && deque.getLast() == n) {
            deque.pollLast();
        }
    }
}