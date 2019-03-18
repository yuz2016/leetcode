package robert.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/1
 */
public class A_47_permuteUnique {

    public static void main(String[] args) {
        A_47_permuteUnique a_47_permuteUnique = new A_47_permuteUnique();
        int[] ints = { 1, 1, 2 };
        System.out.println(a_47_permuteUnique.permuteUnique(ints));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(lists, list, nums, new boolean[nums.length]);
        return lists;
    }

    private void helper(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(lists, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
