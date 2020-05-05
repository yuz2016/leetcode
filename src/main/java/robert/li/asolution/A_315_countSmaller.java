package robert.li.asolution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-16
 */
public class A_315_countSmaller {
    public static void main(String[] args) {
        A_315_countSmaller a_315_countSmaller = new A_315_countSmaller();
        System.out.println(a_315_countSmaller.countSmaller(new int[] { 5, 2, 6, 1 }));
//        System.out.println(a_315_countSmaller.countSmaller(new int[] { 2, 0, 1 }));
//        System.out.println(a_315_countSmaller.countSmaller(new int[] { 1, 9, 7, 8, 5 }));
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> list = new LinkedList<>();
        if(n < 1) return list;
        Integer[] res = new Integer[n];
        Arrays.fill(res, 0);
        int[] tmp = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        reversePairs(nums, 0, n - 1, tmp, res, index);
        return Arrays.asList(res);
    }

    private void reversePairs(int[] nums, int left, int right, int[] temp, Integer[] res, int[] index) {
        if (left == right) return;
        int mid = (left + right) >>> 1;
        reversePairs(nums, left, mid, temp, res, index);
        reversePairs(nums, mid + 1, right, temp, res, index);
        if (nums[index[mid]] <= nums[index[mid + 1]]) {
            return;
        }
        mergeAndCount(nums, left, mid, right, temp, res, index);
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] temp, Integer[] res, int[] index) {
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if(i > mid) {
                index[k] = temp[j];
                j++;
            } else if(j > right) {
                index[k] = temp[i];
                i++;
                res[index[k]] += right - mid;
            } else if(nums[temp[i]] <= nums[temp[j]]) {
                index[k] = temp[i];
                i++;
                res[index[k]] += (j - mid - 1);
            } else {
                index[k] = temp[j];
                j++;
            }
        }
    }
}
