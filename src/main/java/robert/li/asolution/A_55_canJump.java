package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/1
 */
public class A_55_canJump {

    //    /**
    //     * recursive Recursive (top-down)
    //     *
    //     * @param nums
    //     * @return
    //     */
    //    public boolean canJump(int[] nums) {
    //        return helper(nums, nums.length - 1);
    //    }
    //
    //    private boolean helper(int[] nums, int end) {
    //        if (end == 0) {
    //            return true;
    //        }
    //        for (int i = 0; i < end; i++) {
    //            boolean b = (nums[i] >= end - i) && helper(nums, i);
    //            if (b) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }

    private int[] f = new int[30000];

    public static void main(String[] args) {
        int[] a = new int[] { 3, 2, 1, 0, 4 };
        A_55_canJump a_ = new A_55_canJump();
        System.out.println(a_.canJump(a));
    }

    //    /**
    //     * Recursive + memo (top-down)
    //     *
    //     * @param nums
    //     * @return
    //     */
    //    public boolean canJump(int[] nums) {
    //        return helper(nums, nums.length - 1);
    //    }
    //
    //    private boolean helper(int[] nums, int end) {
    //        if (end == 0 || f[end] == 1) {
    //            return true;
    //        }
    //        if (f[end] == -1) {
    //            return false;
    //        }
    //        for (int i = 0; i < end; i++) {
    //            boolean b = (nums[i] >= end - i) && helper(nums, i);
    //            if (b) {
    //                f[end] = 1;
    //                return true;
    //            }
    //        }
    //        f[end] = -1;
    //        return false;
    //    }

    /**
     * Iterative + memo (bottom-up)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        booleans[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (booleans[j] && nums[j] >= i - j) {
                    booleans[i] = true;
                    break;
                }
            }
        }
        return booleans[nums.length - 1];
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int farthestIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthestIndex = Math.max(farthestIndex, nums[i] + i);
            if(farthestIndex <= i) {
                return false;
            }
        }
        return farthestIndex >= nums.length - 1;
    }

}
