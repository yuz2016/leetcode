package robert.li.asolution;

public class A_941_validMountainArray {


    public static void main(String[] args) {
        int[] ints = {0, 3, 2, 1};
        A_941_validMountainArray a_941_validMountainArray = new A_941_validMountainArray();
        boolean b = a_941_validMountainArray.validMountainArray(ints);
        System.out.println(b);
    }

    public boolean validMountainArray(int[] A) {
        if(A.length <= 2) return false;
        int up = 0;
        int down = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if(A[i] == A[i - 1] || A[i] == A[i + 1]) {
                return false;
            }
            if(A[i] > A[i - 1] && A[i] > A[i + 1]) {
                up++;
            }
            if(A[i] < A[i - 1] && A[i] < A[i + 1]) {
                down++;
            }
        }
        return down == 0 && up == 1;
    }
}
