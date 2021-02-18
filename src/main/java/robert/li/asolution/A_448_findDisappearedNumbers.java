package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

public class A_448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0 || nums[i] == i + 1) {
                continue;
            }
            while(nums[i] != i + 1) {
                if(nums[i] == 0) break;
                if(nums[nums[i] - 1] == nums[i]) {
                    nums[i] = 0;
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    void swap(int[] nums, int x, int y) {
        int num = nums[x];
        nums[x] = nums[y];
        nums[y] = num;
    }
}
