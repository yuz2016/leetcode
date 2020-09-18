package robert.li.asolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A_216_combinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, k, n, new ArrayList<>(k), 1);
        return res;
    }

    void dfs(List<List<Integer>> res, int k, int target, List<Integer> list, int start) {
        if(target == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target != 0 && list.size() == k) {
            return;
        }
        for(int i = start; i <= 9; i++) {
            list.add(i);
            dfs(res, k, target - i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
