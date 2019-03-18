package robert.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/1
 */
public class A_15_threeSum {

    /**
     * 此题重点在重复、双向2sum扫描法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i+1,hl = nums.length-1, sum = 0 - nums[i];
                while (lo < hl){
                    if(nums[lo]+nums[hl] == sum){
                        List<Integer> list = Arrays.asList(nums[i], nums[lo], nums[hl]);
                        lists.add(list);
                        while(lo < hl && nums[lo] == nums[lo + 1]){
                            lo++;
                        }
                        while(lo < hl && nums[hl] == nums[hl - 1]){
                            hl--;
                        }
                        lo++;hl--;
                    }else if(nums[lo]+nums[hl] < sum){
                        lo++;
                    }else {
                        hl--;
                    }
                }

            }
        }
        return lists;
    }
}
