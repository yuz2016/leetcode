package robert.li.bsolution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-25
 */
public class B_46_permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        boolean[] visited = new boolean[length];
        helper(nums, 0, length, visited, list, lists);
        return lists;
    }

    void helper(int[] nums, int start, int length, boolean[] visited, List<Integer> list, List<List<Integer>> lists) {
        if(start == length) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, start + 1, length, visited, list, lists);
            list.remove(start);
            visited[i] = false;
        }
    }
}
