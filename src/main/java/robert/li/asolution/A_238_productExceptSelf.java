package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-04
 */
public class A_238_productExceptSelf {
    public static void main(String[] args) {
        A_238_productExceptSelf a_238_productExceptSelf = new A_238_productExceptSelf();
        int[] ints = a_238_productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int tmp = 1;
        // i 左侧乘积
        res[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            tmp *= nums[i];
            res[i + 1] = tmp;
        }

        tmp = 1;
        // i 右侧乘积
        for (int i = n - 1; i > 0; i--) {
            tmp *= nums[i];
            res[i - 1] *= tmp;
        }
        return res;
    }
}
