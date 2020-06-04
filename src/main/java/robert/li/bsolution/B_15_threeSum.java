package robert.li.bsolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-19
 */
public class B_15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int tar = -nums[i];
            int x = i + 1;
            int y = nums.length - 1;
            while(x < y) {
                int sum = nums[x] + nums[y];
                if(sum == tar) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[x]);
                    list.add(nums[y]);
                    res.add(list);
                    while(x < nums.length - 1 && nums[x] == nums[x + 1]) x++;
                    while(y > 0 && nums[y] == nums[y - 1]) y--;
                    x++;
                    y--;
                } else if(sum < tar) {
                    x++;
                } else {
                    y--;
                }
            }
        }
        return res;
    }
}
