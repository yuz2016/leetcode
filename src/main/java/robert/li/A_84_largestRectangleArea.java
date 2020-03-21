package robert.li;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-20
 */
public class A_84_largestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                Integer cur = stack.pop();
                Integer left = stack.peek() + 1;
                Integer right = i - 1;
                res = Math.max(res, heights[cur] * (right - left + 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            Integer cur = stack.pop();
            Integer left = stack.peek() + 1;
            Integer right = heights.length - 1;
            res = Math.max(res, heights[cur] * (right - left + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        A_84_largestRectangleArea a = new A_84_largestRectangleArea();
        a.largestRectangleArea(new int[]{2,1,5,6,2,3});


    }
}
