package robert.li.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/11/30
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        List<String> strings = test.generateParenthesis(3);
        String reportMonth = "2018-12";
        System.out.println(reportMonth.substring(0,4).concat(reportMonth.substring(5,7)));
    }


    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        List<Character> list = new ArrayList<>( 2 * n);
        help(0, 2 * n, list);
        return res;
    }

    void help(int i, int n, List<Character> list) {
        if(i == n) {
            if(isValid(list)){
                char[] chars = new char[n];
                for (int j = 0; j < list.size(); j++) {
                    chars[j] = list.get(j);
                }
                res.add(new String(chars));
            }
            return;
        }
        list.add(i, '(');
        help(i + 1, n, list);
        list.remove(i);

        list.add(i, ')');
        help(i + 1, n, list);
        list.remove(i);
    }

    boolean isValid(List<Character> list) {
        Deque<Character> stack = new LinkedList<>();
        for (Character character : list) {
            if (character == '(') {
                stack.push('(');
            }

            if (character == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
