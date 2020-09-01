package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-20
 */
public class A_167_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i + 1, j + 1};
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
