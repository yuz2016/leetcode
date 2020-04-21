package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-17
 */
public class B_55_canJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if(i == maxIndex) {
                break;
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
