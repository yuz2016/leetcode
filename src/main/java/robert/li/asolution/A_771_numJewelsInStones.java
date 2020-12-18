package robert.li.asolution;

import java.util.HashSet;
import java.util.Set;

public class A_771_numJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        char[] charsJ = J.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : charsJ) {
            set.add(aChar);
        }
        char[] charsS = S.toCharArray();
        int res = 0;
        for (char s : charsS) {
            if(set.contains(s)) res++;
        }
        return res;
    }
}
