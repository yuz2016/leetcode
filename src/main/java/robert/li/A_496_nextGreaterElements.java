package robert.li;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-02
 */
public class A_496_nextGreaterElements {
//    public int[] nextGreaterElements(int[] nums) {
//        Stack<Integer> stack = new Stack<>();
//        int[] res = new int[nums.length];
//        for (int i = nums.length - 1; i >= 0; i--) {
//            while(!stack.isEmpty() && stack.peek() < nums[i]) {
//                stack.pop();
//            }
//            res[i] = stack.isEmpty()? -1 : stack.peek();
//            stack.push(nums[i]);
//        }
//        return res;
//    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty()? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
