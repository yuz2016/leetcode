package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-14
 */
public class M_51_reversePairs {
    public int reversePairs(int[] nums) {
        int length = nums.length;
        if(length < 2) return 0;
        int[] temp = new int[length];
        return reversePairs(nums, 0, length - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right)
            return 0;

        int mid = (left + right) >>> 1;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        int reversePairs = leftPairs + rightPairs;
        if (nums[mid] <= nums[mid + 1]) {
            return reversePairs;
        }
        int reverseCrossPairs = mergeAndCount(nums, left, mid, right, temp);
        return reversePairs + reverseCrossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = left; k <= right; k++) {
            if(i > mid) {
                nums[k] = temp[j];
                j++;
            } else if(j > right) {
                nums[k] = temp[i];
                i++;
            } else if(temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                res += mid - i + 1;
            }
        }
        return res;
    }
}
