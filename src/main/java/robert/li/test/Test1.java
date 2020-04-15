package robert.li.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/12
 */
public class Test1 {
    public static void main(String[] args) {
//        Iterable<Integer> integers = Arrays.asList(1,2,3,4);
        Iterable<Integer> integers = Lists.newArrayList();
        ArrayList<Integer> integers1 = Lists.newArrayList(Iterables.filter(integers, integer -> integer != 1));
        System.out.println(integers1.toString());
        int size = Iterables.size(integers);
        System.out.println("size:"+size);
        Integer last = Iterables.getLast(integers);
        System.out.println("last:"+last);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        Arrays.sort(candidates); // 用于剪枝
        List<List<Integer>> lists = new ArrayList<>();
        dfs(candidates, length, target, 0, new LinkedList<>(), lists);
        return lists;
    }

    private void dfs(
            int[] candidates,
            int length,
            int target,
            int start,
            List<Integer> path,
            List<List<Integer>> res
            ) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < length; i++) {
            if(candidates[i] > target) {
                break;
            }
            int tmp = target - candidates[i];
            path.add(candidates[i]);
            dfs(candidates, length, tmp, i, path, res);
            path.remove(path.size() - 1);
        }
    }


}
