package robert.li;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-13
 */
public class A_139_wordBreak {

    public static void main(String[] args) {
        int code = "leetcode".lastIndexOf("code");
        int code1 = "leetcode".lastIndexOf("dode");
        System.out.println("code : " + code);
        System.out.println("code1 : " + code1);
        System.out.println("leetcode".substring(0, 2));
        A_139_wordBreak a = new A_139_wordBreak();
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
        int n = s.length();
        int size = wordDict.size();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < dp.length; i++) {
            boolean b = false;
            for(int j = 0; j < size; j++) {
                String word = wordDict.get(j);
                if(i - word.length() + 1 >= 0 && wordIsTailOfString(s, i, word) && (i - word.length() + 1 == 0 || dp[i - word.length()])) {
                    b = true;
                    break;
                }
            }
            dp[i] = b;
        }
        return dp[n - 1];
    }

    boolean wordIsTailOfString(String s, int i, String word) {
        String substring = s.substring(0, i + 1);
        int i1 = substring.lastIndexOf(word);
        return i1 == (i - word.length() + 1);
    }
}
