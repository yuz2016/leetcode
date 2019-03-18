package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/29
 */
public class NumSubarraysWithSum {
    public static void main(String[] args) {
        int[] A = { 1, 0, 1, 0, 1 };
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        int i = numSubarraysWithSum.numSubarraysWithSum(A, 2);
        int a = 0;
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0, count = 0;

        int presum[] = new int[30003];
        presum[0] = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum-S>=0){
                count+=presum[sum-S];
            }
            presum[sum] += 1;
        }
        return count;
    }
}
