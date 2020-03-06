package robert.li;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-05
 */
public class M_9_CQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public M_9_CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if(s2.isEmpty()) return -1;
        return s2.pop();
    }
}
