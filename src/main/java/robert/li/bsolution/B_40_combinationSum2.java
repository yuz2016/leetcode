package robert.li.bsolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-10
 */
public class B_40_combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        dfs(target, candidates, 0, res, new LinkedList<>());
        return res;
    }

    void dfs(int target, int[] candi, int start, List<List<Integer>> res, List<Integer> list) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < candi.length; i++) {
            if (target - candi[i] < 0) {
                break;
            }
            if(i > start && candi[i] == candi[i - 1]) continue;
            list.add(candi[i]);
            int tmp = target - candi[i];
            dfs(tmp, candi, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
