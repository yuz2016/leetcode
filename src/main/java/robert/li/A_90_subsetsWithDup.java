package robert.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/5
 */
public class A_90_subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
