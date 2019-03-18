package robert.li;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/1
 */
public class A_17_letterCombinations {

//    /**
//     * FIFO queue
//     *
//     * @param digits
//     * @return
//     */
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> ans = new LinkedList<>();
//        if (digits.isEmpty()) {
//            return ans;
//        }
//        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//        ans.add("");
//        while (ans.peek().length() != digits.length()) {
//            String remove = ans.remove();
//            String map = mapping[digits.charAt(remove.length()) - '0'];
//            for (char c : map.toCharArray()) {
//                ans.addLast(remove + c);
//            }
//        }
//        return ans;
//    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    /**
     * recursive
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}
