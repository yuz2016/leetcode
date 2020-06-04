package robert.li.bsolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-30
 */
public class B_84_largestRectangleArea {
    public static void main(String[] args) {
        B_84_largestRectangleArea b = new B_84_largestRectangleArea();
        int i = b.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int[] before = new int[heights.length];
        int[] after = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) {
                stack.push(i);
                before[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() != -1) {
                    if (heights[stack.peek()] >= heights[i]) {
                        stack.pop();
                    } else {
                        before[i] = stack.peek();
                        stack.push(i);
                        break;
                    }
                    if (!stack.isEmpty() && stack.peek() == -1) {
                        before[i] = -1;
                        stack.push(i);
                        break;
                    }
                }
            }
        }
        stack.clear();
        stack.push(heights.length);
        for (int i = heights.length - 1; i >= 0; i--) {
            if (i == heights.length - 1) {
                stack.push(heights.length - 1);
                after[i] = heights.length;
            } else {
                while (!stack.isEmpty() && stack.peek() != heights.length) {
                    if (heights[stack.peek()] >= heights[i]) {
                        stack.pop();
                    } else {
                        after[i] = stack.peek();
                        stack.push(i);
                        break;
                    }
                    if (!stack.isEmpty() && stack.peek() == heights.length) {
                        after[i] = heights.length;
                        stack.push(i);
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (after[i] - before[i] - 1));
        }
        return res;
    }
}
