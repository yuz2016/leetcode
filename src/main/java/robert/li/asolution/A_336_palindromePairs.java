package robert.li.asolution;

import java.util.*;

public class A_336_palindromePairs {
    public static void main(String[] args) {
        A_336_palindromePairs a_336_palindromePairs = new A_336_palindromePairs();
        List<List<Integer>> lists = a_336_palindromePairs.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                List<Integer> list1 = new ArrayList<>(2);
                list1.add(i);
                list1.add(map.get(words[i]));
                List<Integer> list2 = new ArrayList<>(2);
                list2.add(map.get(words[i]));
                list2.add(i);
                res.add(list1);
                res.add(list2);
            } else {
                map.put(reverse(words[i]), i);
            }
        }
        return res;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
