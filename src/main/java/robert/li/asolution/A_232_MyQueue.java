package robert.li.asolution;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-05
 */
public class A_232_MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public A_232_MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        if(s2.isEmpty()) return -1;
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if(s2.isEmpty()) return -1;
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
