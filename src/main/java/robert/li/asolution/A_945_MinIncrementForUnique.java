package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/11/25
 */
public class A_945_MinIncrementForUnique {

    public static void main(String[] args) {
        int[] a = {1,2,2};
        System.out.println(minIncrementForUnique(a));
    }
    public static int minIncrementForUnique(int[] A) {
        int[] count = new int[100000];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }

        int ans = 0, taken = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                taken += (count[i] - 1);
                ans -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                taken--;
                ans += i;
            }
        }
        return ans;

    }
}
