package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-17
 */
public class A_35_searchInsert {
    public static void main(String[] args) {
        A_35_searchInsert a_35_searchInsert = new A_35_searchInsert();
        int i = a_35_searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(i);
    }
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while(l < r) {
            int mid = r + (l - r) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(mid < target) {
                l = mid + 1;
            } else if(mid > target) {
                r = mid - 1;
            }
        }
        if(l == 0 && nums[l] > target) {
            return l;
        }
        if(l > 0 && nums[l] > target) {
            return l - 1;
        }
        if(l > 0 && nums[l] < target) {
            return l + 1;
        }
        return -1;
    }

    public int searchInsert1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        // 因为有可能数组的最后一个元素的位置的下一个是我们要找的，故右边界是 len
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left, mid]
                right = mid;
            }
        }
        return left;
    }
}
