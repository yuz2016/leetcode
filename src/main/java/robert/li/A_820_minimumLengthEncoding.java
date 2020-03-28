package robert.li;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-28
 */
public class A_820_minimumLengthEncoding {

    public static void main(String[] args) {
        String[] strings = new String[] { "time", "me", "bell" };
        A_820_minimumLengthEncoding a = new A_820_minimumLengthEncoding();
        a.minimumLengthEncoding(strings);
    }

    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0)
            return 0;
        // words 按word.length 从大到小 排序
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());

        // 遍历words,
        // Set不存在, 添加到Set 并记录长度, 并把以最后一个字符结尾字串也添加Set,
        // 如果存在，不计入长度
        int len = 0;
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (sets.contains(words[i])) {
                continue;
            } else {
                len += words[i].length() + 1;
                for (int j = 0; j < words[i].length(); j++) {
                    sets.add(words[i].substring(j));
                }
            }
        }
        return len;
    }
}
