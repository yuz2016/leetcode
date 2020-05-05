package robert.li.asolution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-19
 */
public class A_466_getMaxRepetitions {
    public static void main(String[] args) {
        A_466_getMaxRepetitions a_466_getMaxRepetitions = new A_466_getMaxRepetitions();
        int maxRepetitions = a_466_getMaxRepetitions.getMaxRepetitions("abc", 4, "ab", 2);
        System.out.println(maxRepetitions);
        //        int maxRepetitions = a_466_getMaxRepetitions.getMaxRepetitions("aaa", 3, "aa", 1);
        //        System.out.println(maxRepetitions);
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 统计s2是否含有s1不含的字符
        if (s2NotContainsS1Char(s1, s2))
            return -1;
        // 检查s2是否能从[s1, n1]获得
        int countFromS1 = s2CountFromS1(s1, s2);
        if (countFromS1 == 0) {
            int countFromS2 = s2CountFromS1(s2, s1);
            if (countFromS2 > n1) {
                return -1;
            }
        }
        return helper(s1, n1, s2, n2);
    }

    private int helper(String s1, int n1, String s2, int n2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        int countI = 1;
        int countJ = 0;
        int res = 0;
        while (countI <= n1) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else {
                i++;
            }
            if (i == chars1.length) {
                i = 0;
                countI++;
            }
            if (j == chars2.length) {
                j = 0;
                countJ++;
                if (countJ == n2) {
                    res++;
                    countJ = 0;
                }
            }
        }
        return res;
    }

    private int s2CountFromS1(String s1, String s2) {
        int res = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s1.toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            } else {
                i++;
            }
            // 回到起点
            if (j == chars2.length) {
                j = 0;
                res++;
            }
        }
        return res;
    }

    private boolean s2NotContainsS1Char(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        char[] chars1 = s1.toCharArray();
        for (char aChar : chars1) {
            set.add(aChar);
        }
        char[] chars2 = s2.toCharArray();
        for (char c : chars2) {
            if (!set.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
