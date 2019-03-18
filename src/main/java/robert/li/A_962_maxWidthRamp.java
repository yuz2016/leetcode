package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/23
 */
public class A_962_maxWidthRamp {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp1(new int[] { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 }));
    }

    /**
     * n*log(n)
     * 一开始理解每次扫描数组，只扫描一半是n*log(n),其实是这样的n*(n/2)
     *
     * @param A
     * @return
     */
    public static int maxWidthRamp1(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int j = A.length - 1;
            while (i != j) {
                if (A[i] <= A[j]) {
                    res = Math.max(res, j - i);
                }
                j--;
            }
        }
        return res;
    }

    /**
     * 不行，原因是同时++i --j 这样做不是很合理
     *
     * @param A
     * @return
     */
    public static int maxWidthRamp(int[] A) {
        int i = 0, j = A.length - 1, min = A[0], max = A[A.length - 1], m = 0, n = A.length - 1;
        while (i < j) {
            if (min <= max) {
                return n - m;
            }
            if (A[++i] < min) {
                min = A[i];
                m = i;
            }

            if (A[--j] > max) {
                max = A[j];
                n = j;
            }
        }
        return 0;
    }

    /**
     * Approach 1: Sort
     * Intuition and Algorithm
     * <p>
     * For all elements like A[i] = v, let's write the indices i in sorted order of their values v. For example with A[0] = 7, A[1] = 2, A[2] = 5, A[3] = 4, we can write the order of indices i=1, i=3, i=2, i=0.
     * <p>
     * Then, whenever we write an index i, we know there was a ramp of width i - min(indexes_previously_written) (if this quantity is positive). We can keep track of the minimum of all indexes previously written as m.
     *
     * @param A
     * @return
     */
    public int maxWidthRamp2(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i : B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
