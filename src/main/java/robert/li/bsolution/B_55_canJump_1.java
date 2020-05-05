package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-04
 */
public class B_55_canJump_1 {
    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i > maxIndex) {
                break;
            } else {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
