package robert.li.asolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/11/11
 */
public class A_940_DistinctSubseqII {
    public int distinctSubseqII(String S) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            String substring = S.substring(i, i + 1);
            List<String> list = new ArrayList<>();
            strings.forEach(j->{
                String tmp = j+substring;
                list.add(tmp);
            });
            strings.addAll(list);
            strings.add(substring);
        }
        return strings.size();
    }
}
