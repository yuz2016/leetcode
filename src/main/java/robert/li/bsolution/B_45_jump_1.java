package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-04
 */
public class B_45_jump_1 {
    public int jump(int[] nums) {
        int step = 1;
        int curMaxIndex = nums[0];
        int nextMaxIndex = curMaxIndex;
        for (int i = 1; i < nums.length; i++) {
            if(i > curMaxIndex) {
                step++;
                curMaxIndex = nextMaxIndex;
            }
            nextMaxIndex = Math.max(nextMaxIndex, i + nums[i]);
        }
        return step;
    }
}
