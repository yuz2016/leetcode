package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/7
 */
public class A_40_combinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        A_40_combinationSum2 a_39_combinationSum = new A_40_combinationSum2();
        a_39_combinationSum.combinationSum2(arr, 8);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (target < 1) {
            return lists;
        }
        Arrays.sort(candidates);
        backtrack(lists, new ArrayList<>(), candidates, 0, target, 0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] candidates, int sum, int target,
            int start) {
        if (sum == target) {
            lists.add(new ArrayList<>(tempList));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            backtrack(lists, tempList, candidates, sum + candidates[i], target, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
