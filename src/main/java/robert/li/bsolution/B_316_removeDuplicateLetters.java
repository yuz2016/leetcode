package robert.li.bsolution;

import java.util.*;

public class B_316_removeDuplicateLetters {
    public static void main(String[] args) {
        B_316_removeDuplicateLetters b_316_removeDuplicateLetters = new B_316_removeDuplicateLetters();
        b_316_removeDuplicateLetters.removeDuplicateLetters("bbcaac");
    }

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        Deque<Character> stack = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if(set.contains(chars[i])) {
                map.put(chars[i], map.get(chars[i]) - 1);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > chars[i] && map.get(stack.peek()) > 1 ) {
                Character pop = stack.pop();
                map.put(pop, map.get(pop) - 1);
                set.remove(pop);
            }
            stack.push(chars[i]);
            set.add(chars[i]);
        }
        char[] res = new char[map.size()];
        for (int i = map.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
