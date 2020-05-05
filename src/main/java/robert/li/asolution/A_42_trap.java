package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-20
 */
public class A_42_trap {

    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = max;
            max = Math.max(height[i], max);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(height[i], max);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int tmp = Math.min(leftMax[i], rightMax[i]);
            if(tmp > height[i]) {
                res += tmp - height[i];
            }
        }
        return res;
    }
}
