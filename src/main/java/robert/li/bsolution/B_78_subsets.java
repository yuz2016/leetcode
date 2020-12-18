package robert.li.bsolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B_78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, 0, nums);
        return res;
     }


     void dfs(List<List<Integer>> res, List<Integer> list, int start, int[] nums) {
        List<Integer> cur = new ArrayList<>(list);
        res.add(cur);
        if(start == nums.length) return;
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
     }
}
