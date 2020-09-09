package robert.li.bsolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-09
 */
public class B_39_combinationSum {
    public static void main(String[] args) {
        B_39_combinationSum b_39_combinationSum = new B_39_combinationSum();
        List<List<Integer>> lists = b_39_combinationSum.combinationSum(new int[]{2, 3, 6,7}, 7);
        int i = 0;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(target, candidates, 0, res, new LinkedList<>());
        return res;
    }

    void dfs(int target, int[] candi, int start, List<List<Integer>> res, List<Integer> list) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < candi.length; i++) {
            list.add(candi[i]);
            int tmp = target - candi[i];
            dfs(tmp, candi, i, res, list);
            list.remove(list.size() - 1);
        }
    }
}
