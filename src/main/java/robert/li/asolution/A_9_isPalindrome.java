package robert.li.asolution;

import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-10
 */
public class A_9_isPalindrome {
    public static void main(String[] args) {
        A_9_isPalindrome a_9_isPalindrome = new A_9_isPalindrome();
        a_9_isPalindrome.isPalindrome(1001);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int count = getCount(x);
        boolean b = count % 2 == 1;
        int s = count / 2;
        int i = 1;
        LinkedList<Integer> stack = new LinkedList<>();
        while (x != 0) {
            int cur = x % 10;
            if (b) {
                if (i <= s) {
                    stack.push(cur);
                } else if (i > s + 1) {
                    if (!stack.peek().equals(cur)) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            } else {
                if (i <= s) {
                    stack.push(cur);
                } else if (i > s) {
                    Integer peek = stack.peek();
                    int cur1 = cur;
                    if (!stack.peek().equals(cur)) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            i++;
            x = x / 10;
        }
        return true;
    }

    int getCount(int x) {
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count++;
        }
        return count;
    }


}
