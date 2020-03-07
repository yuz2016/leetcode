package robert.li;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-07
 */
public class M_59_MaxQueue {

    Queue<Integer> queue = new LinkedList<>();
    LinkedList<Integer> monoQueue = new LinkedList<>();

    public M_59_MaxQueue() {

    }

    public int max_value() {
        if(monoQueue.isEmpty()) {
            return -1;
        } else return monoQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!monoQueue.isEmpty() && monoQueue.peekLast() < value) {
            monoQueue.pollLast();
        }
        monoQueue.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        Integer poll = queue.poll();
        if(monoQueue.peekFirst().equals(poll)) {
            monoQueue.pollFirst();
        }
        return poll;
    }
}
