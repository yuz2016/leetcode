package robert.li;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-01
 */
public class A_225_myStack {

    List<Integer> list;

    /** Initialize your data structure here. */
    public A_225_myStack() {
        list = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(0, x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(list.isEmpty()) return -1;
        return list.remove(0);
    }

    /** Get the top element. */
    public int top() {
        return list.get(0);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}
