package robert.li;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/8
 */
public class A_131_partition {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        backtrace(lists, new ArrayList<>(), s, 0);
        return lists;
    }

    private void backtrace(List<List<String>> lists, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.toCharArray().length; i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start,i+1));
                    backtrace(lists,tempList,s,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high && s.charAt(low) == s.charAt(high)) {
            low++;
            high--;
        }
        return low >= high;
    }
}
