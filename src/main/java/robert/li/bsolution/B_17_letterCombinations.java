package robert.li.bsolution;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B_17_letterCombinations {

    String[] s = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();
        if(chars.length == 0) {
            return res;
        }
        List<Character> list = new LinkedList<>();
        helper(res, chars, 0, list);
        return res;
    }

    void helper(List<String> res, char[] chars, int start, List<Character> list) {
        if(start == chars.length) {
            res.add(getString(list));
            return;
        }
        char aChar = chars[start];
        int index = aChar - '0';
        String s = this.s[index];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            list.add(charArr[i]);
            helper(res, chars, start + 1, list);
            list.remove(list.size() - 1);
        }
    }

    String getString(List<Character> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
