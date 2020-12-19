package robert.li.asolution;

import java.util.Stack;

public class A_402_removeKdigits {
    public String removeKdigits(String num, int k) {
        if(k == 0) return removeFirstZeros(num);
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] > chars[i + 1]) {
                return removeKdigits(removeKth(num, i), k - 1);
            }
        }
        return removeFirstZeros(num.substring(0, num.length() - k));
    }

    String removeKth(String num, int kth) {
        String first = num.substring(0, kth);
        String last = "";
        if(kth != num.length() - 1) {
            last = num.substring(kth + 1);
        }
        return first + last;
    }

    String removeFirstZeros(String num) {
        char[] chars = num.toCharArray();
        int i = 0;
        while(i < chars.length && chars[i] == '0') i++;
        return num.substring(i).equals("") ? "0" : num.substring(i);
    }

    public String removeKdigits1(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > chars[i]) {
                stack.pop();
                k--;
            }
            stack.push(chars[i]);
        }
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return removeFirstZeros(res.toString());
    }
}
