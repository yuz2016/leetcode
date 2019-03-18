package robert.li;

import java.util.Stack;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/25
 */
public class A_682_calPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if(op.equals("C")){
                stack.pop();
            } else if(op.equals("+")){
                Integer pop = stack.pop();
                Integer newpop = pop + stack.peek();
                stack.push(pop);
                stack.push(newpop);
            } else if(op.equals("D")){
                Integer i = stack.peek() * 2;
                stack.push(i);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int res = 0;
        for (Integer integer : stack) {
            res+=integer;
        }
        return res;
    }
}
