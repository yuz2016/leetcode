package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-19
 */
public class A_283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int cur = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                swap(nums, i, cur);
                cur++;
            }
            i++;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
