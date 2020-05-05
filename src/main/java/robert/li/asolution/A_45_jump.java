package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-19
 */
public class A_45_jump {
    /**
     * 贪心
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int farthestIndex = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthestIndex = Math.max(farthestIndex, nums[i] + i);
            if(end == i) {
                step++;
                end = farthestIndex;
            }
        }
        return step;
    }
}
