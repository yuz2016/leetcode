package robert.li;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/1
 */
public class A_46_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(lists, list, nums);
        return lists;
    }

    private void helper(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(lists, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
