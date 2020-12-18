package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-10
 */
public class A_31_nextPermutation {
    public static void main(String[] args) {

        A_31_nextPermutation a_31_nextPermutation = new A_31_nextPermutation();
        a_31_nextPermutation.nextPermutation(new int[]{5, 1, 1});
    }

    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length - 1;
        // 从后往前，找第一个生序
        while(i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        int j = nums.length - 1;
        if(i != 0) {
            // 找到第一个生序 a < b > c > d
            i--;
            // a和后面最小的比a大的元素交换
            while(j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            // a后面的元素顺序颠倒
            swapRange(nums, i + 1, nums.length - 1);
        } else {
            // 没找到第一个生序
            swapRange(nums, 0, nums.length - 1);
        }
    }

    void swapRange(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
