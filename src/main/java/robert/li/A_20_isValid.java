package robert.li;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-12
 */
public class A_20_isValid {

    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if(stack.isEmpty() || (chars[i] == '(' || chars[i] == '{' || chars[i] == '[')) {
                stack.push(chars[i]);
            } else {
                Character peek = stack.peek();
                if(peek == '(' && chars[i] == ')') {
                    stack.pop();
                    continue;
                }
                if(peek == '{' && chars[i] == '}') {
                    stack.pop();
                    continue;
                }
                if(peek == '[' && chars[i] == ']') {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
