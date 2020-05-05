package robert.li.asolution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-12
 */
public class M_38_permutation {
    public static void main(String[] args) {
        M_38_permutation m = new M_38_permutation();
        String[] abcs = m.permutation("aac");
        System.out.println(abcs);
    }

    Set<String> list = new HashSet<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        help(chars, "", new HashSet<>());
        String[] strings = list.toArray(new String[0]);
        return strings;
    }

    void help(char[] chars, String s, Set<Integer> set) {
        if(s.length() == chars.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(set.contains(i)) continue;
            set.add(i);
            help(chars, s + chars[i], set);
            set.remove(i);
        }
    }
}
