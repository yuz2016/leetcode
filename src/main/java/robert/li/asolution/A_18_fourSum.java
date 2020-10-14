package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-05
 */
public class A_18_fourSum {

    public static void main(String[] args) {
        int[] test = new int[]{1,0,-1,0,-2,2};
        A_18_fourSum a_18_fourSum = new A_18_fourSum();
        List<List<Integer>> lists = a_18_fourSum.fourSum(test, 0);
        int i = 0;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int tmpTar = target - nums[i] - nums[j];
                int x = j + 1;
                int y = nums.length - 1;
                while(x < y) {
                    if(nums[x] + nums[y] < tmpTar) {
                        x++;
                    } else if(nums[x] + nums[y] > tmpTar){
                        y--;
                    } else {
                        if(x > j + 1 && nums[x] == nums[x - 1]) {
                            x++;
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[x]);
                            list.add(nums[y]);
                            res.add(list);
                            x++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
