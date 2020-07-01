package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-30
 */
public class J_09_CQueue {
    Deque<Integer> stackAdd = new LinkedList<>();
    Deque<Integer> stackPoll = new LinkedList<>();

    public void appendTail(int value) {
        stackAdd.push(value);
    }

    public int deleteHead() {
        if(stackPoll.isEmpty()) {
            while(!stackAdd.isEmpty()) {
                stackPoll.push(stackAdd.pop());
            }
        }
        if(stackPoll.isEmpty()) {
            return -1;
        }
        return stackPoll.pop();
    }
}
