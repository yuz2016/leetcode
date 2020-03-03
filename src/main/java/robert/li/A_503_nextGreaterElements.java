package robert.li;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-03
 */
public class A_503_nextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty()? - 1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
