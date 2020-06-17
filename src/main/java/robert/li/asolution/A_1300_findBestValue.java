package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-14
 */
public class A_1300_findBestValue {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = arr[0];
        for (int i = 1; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
        }
        while(left < right) {
            int mid = left + (right - left) / 2;
            int cur = calculatSum(arr, mid);
            if(cur < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int i0 = calculatSum(arr, left);
        int i1 = calculatSum(arr, left - 1);
        if(i0 - target >= target - i1) {
            return left - 1;
        }
        return left;
    }

    private int calculatSum(int[] arr, int value) {
        int sum = 0;
        for (int i : arr) {
            if(i > value) {
                sum += value;
            } else {
                sum += i;
            }
        }
        return sum;
    }


}
