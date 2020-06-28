package robert.li.bsolution;

import robert.li.asolution.A_139_wordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B_139_wordBreak {
    public static void main(String[] args) {
        int code = "leetcode".lastIndexOf("code");
        int code1 = "leetcode".lastIndexOf("dode");
        System.out.println("code : " + code);
        System.out.println("code1 : " + code1);
        System.out.println("leetcode".substring(0, 2));
        B_139_wordBreak a = new B_139_wordBreak();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean leetcode = a.wordBreak("leetcode", list);
        System.out.println(leetcode);

        List<String> list1 = new ArrayList<>();
        list1.add("apple");
        list1.add("pen");
        boolean leetcode1 = a.wordBreak("applepenapple", list1);
        System.out.println(leetcode1);

        List<String> list2 = new ArrayList<>();
        list2.add("cats");
        list2.add("dog");
        list2.add("sand");
        list2.add("and");
        list2.add("cat");
        boolean leetcode2 = a.wordBreak("catsandog", list2);
        System.out.println(leetcode2);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            boolean b = false;
            for(int j = i; j >= 0; j--) {
                String substring = s.substring(j, i + 1);
                if(set.contains(substring) && (j == 0 || dp[j - 1])) {
                    b = true;
                    break;
                }
            }
            dp[i] = b;
        }
        return dp[s.length() - 1];
    }
}
