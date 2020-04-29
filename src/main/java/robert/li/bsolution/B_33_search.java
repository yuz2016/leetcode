package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-29
 */
public class B_33_search {
    public static void main(String[] args) {
        B_33_search b_33_search = new B_33_search();
        int search = b_33_search.search(new int[] { 1, 2 }, 2);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] < nums[mid]) {
                if(target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            } else {
                if(target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
