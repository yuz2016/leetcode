package robert.li.asolution;

import java.util.*;

public class A_491_findSubsequences {

    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 1};
        A_491_findSubsequences a_491_findSubsequences = new A_491_findSubsequences();
        List<List<Integer>> subsequences = a_491_findSubsequences.findSubsequences(ints);
        System.out.println(subsequences);
    }



    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        Set<String> set = new HashSet<>();
        helper(nums, 0, res, list, set);
        return res;
    }

    void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> list, Set<String> set) {
        if(list.size() > 1) {
            String s = list.toString();
            if(!set.contains(s)) {
                res.add(new ArrayList<>(list));
                set.add(s);
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (list.size() >= 1 && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i + 1, res, list, set);
            list.remove(list.size() - 1);
        }
    }
}
