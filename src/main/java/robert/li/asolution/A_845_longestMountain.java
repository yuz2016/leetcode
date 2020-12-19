package robert.li.asolution;

public class A_845_longestMountain {

    public static void main(String[] args) {
        int[] ints = {0, 1, 0};
        A_845_longestMountain a_845_longestMountain = new A_845_longestMountain();
        a_845_longestMountain.longestMountain(ints);
    }

    public int longestMountain(int[] A) {
        int length = A.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if(A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if(left[i] > 0 && right[i] > 0) {
                res = Math.max(res, 1 + left[i] + right[i]);
            }
        }
        return res;
    }
}
