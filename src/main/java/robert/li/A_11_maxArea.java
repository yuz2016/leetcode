package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-18
 */
public class A_11_maxArea {
    public static void main(String[] args) {
        int[] ints = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        A_11_maxArea a_11_maxArea = new A_11_maxArea();
        int i = a_11_maxArea.maxArea(ints);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int capacity = 0;
        while (i < j) {
            int curMinHeight = Math.min(height[i], height[j]);
            capacity = Math.max(capacity, (j - i) * curMinHeight);
            if (height[i] < height[j]) {
                while (i < j && height[++i] < curMinHeight) {
                }
            } else {
                while (i < j && height[--j] < curMinHeight) {
                }
            }
        }
        return capacity;
    }
}
