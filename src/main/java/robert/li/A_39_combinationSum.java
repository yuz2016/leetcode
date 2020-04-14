package robert.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/7
 */
public class A_39_combinationSum {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        int target = 7;
        A_39_combinationSum a_39_combinationSum = new A_39_combinationSum();
        List<List<Integer>> lists = a_39_combinationSum.combinationSum(arr, 7);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            tempList.add(candidates[i]);
            backtrack(lists, tempList, candidates, sum + candidates[i], target, i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
