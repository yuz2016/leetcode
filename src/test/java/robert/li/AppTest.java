package robert.li;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // memo[i] 表示 以memo[i]为结尾的最长上升子序列 长度
        int[] memo = new int[n];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, memo[j]);
                }
            }
            memo[i] = max + 1;
            res = Math.max(res, memo[i]);
        }
        return res;
    }
}
