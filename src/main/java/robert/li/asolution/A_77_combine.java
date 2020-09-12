package robert.li.asolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-08
 */
public class A_77_combine {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(n, k, 1, new ArrayList<>(k), res);
        return res;
    }

    void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n + 1 - (k - list.size()); i++) {
            list.add(i);
            dfs(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
