package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-26
 */
public class A_287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) {
                    count++;
                }
            }
            if(count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
