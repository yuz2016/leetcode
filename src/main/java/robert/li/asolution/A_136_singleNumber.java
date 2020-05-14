package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-14
 */
public class A_136_singleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length;i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
