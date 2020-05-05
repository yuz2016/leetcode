package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-01
 */
public class A_1111_maxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        if(seq == null || seq.equals("")) return new int[0];
        char[] chars = seq.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar == '(') {
                res[i] = stack.size() % 2;
                stack.push('(');
            } else {
                stack.pop();
                res[i] = stack.size() % 2;
            }
        }
        return res;
    }
}
