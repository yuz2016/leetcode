package robert.li;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/1
 */
public class A_46_permute {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();
        helper(list, nums);
        return lists;
    }

    private void helper(List<Integer> list, int[] nums) {
        // 结束条件
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        // list 路径
        // 选择添加
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(list, nums);
            list.remove(list.size() - 1);
        }
    }
}
