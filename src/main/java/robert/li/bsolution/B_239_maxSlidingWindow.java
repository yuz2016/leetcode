package robert.li.bsolution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class B_239_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while(i < k) {
            addstack(stack, i, nums);
            i++;
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[stack.peekFirst()]);
        while(i < nums.length) {
            addstack(stack, i, nums);
            while (stack.peekFirst() < i - k + 1) {
                stack.pollFirst();
            }
            res.add(nums[stack.peekFirst()]);
            i++;
        }
        int[] arr = new int[res.size()];
        for (int i1 = 0; i1 < res.size(); i1++) {
            arr[i1] = res.get(i1);
        }
        return arr;
    }

    void addstack(Deque<Integer> stack, int index, int[] nums) {
        while(!stack.isEmpty() && nums[stack.peekLast()] <= nums[index]) {
            stack.pollLast();
        }
        stack.addLast(index);
    }
}
