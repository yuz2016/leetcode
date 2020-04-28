package robert.li.bsolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-25
 */
public class B_945_minIncrementForUnique {
    public static void main(String[] args) {
        B_945_minIncrementForUnique b_945_minIncrementForUnique = new B_945_minIncrementForUnique();
//        int i = b_945_minIncrementForUnique.minIncrementForUnique(new int[] { 1, 2, 2 });
        int i = b_945_minIncrementForUnique.minIncrementForUnique(new int[] { 3,2,1,2,1,7 });
        System.out.println(i);

    }

    public int minIncrementForUnique(int[] nums) {
        int[] arr = new int[40000];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count > 0) {
                res += count;
            }
            if (arr[i] > 1) {
                count += arr[i] - 1;
            }
            if(arr[i] == 0 && count > 0) {
                count--;
            }
        }
        return res;
    }
}
