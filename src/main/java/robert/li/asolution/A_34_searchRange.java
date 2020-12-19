package robert.li.asolution;

import java.util.Arrays;

public class A_34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if(nums.length < 1) return res;
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target? left : -1;
    }

    int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target? left : -1;
    }
}
