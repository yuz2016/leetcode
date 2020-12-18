package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-26
 */
public class A_1365_smallerNumbersThanCurrent {


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);
        int[] freqArr = new int[101];
        for (int i = 1; i < sortedArr.length; i++) {
            if(sortedArr[i] > sortedArr[i - 1]) {
                freqArr[sortedArr[i]] = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = freqArr[nums[i]];
        }
        return nums;
    }
}
