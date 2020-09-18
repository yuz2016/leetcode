package robert.li.bsolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-25
 */
public class B_47_permuteUnique {
    public static void main(String[] args) {
        B_47_permuteUnique b_47_permuteUnique = new B_47_permuteUnique();
        List<List<Integer>> lists = b_47_permuteUnique.permuteUnique(new int[] { 1, 1, 1, 2 });
//        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        boolean[] visited = new boolean[length];
        helper(nums, 0, length, visited, list, lists);
        return lists;
    }

    void helper(int[] nums, int start, int length, boolean[] visited, List<Integer> list, List<List<Integer>> lists) {
        System.out.println(list);
        if(start == length) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, start + 1, length, visited, list, lists);
            list.remove(start);
            visited[i] = false;
        }
    }
}
