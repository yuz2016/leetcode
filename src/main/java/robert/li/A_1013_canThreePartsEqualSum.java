package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-11
 */
public class A_1013_canThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if(sum % 3 != 0) return false;
        int one = sum / 3;
        boolean oneFlag = false,twoFlag = false;
        sum = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if(!oneFlag && sum == one) {
                oneFlag = true;
            } else if(oneFlag && sum == 2 * one) {
                twoFlag = true;
                index = i;
                break;
            }
        }
        return oneFlag && twoFlag && index != a.length - 1;
    }

    public static void main(String[] args) {
        A_1013_canThreePartsEqualSum a = new A_1013_canThreePartsEqualSum();
//        a.canThreePartsEqualSum(new int[]{10,-10,10,-10,10,-10,10,-10});
        a.canThreePartsEqualSum(new int[]{1,-1,1,-1});
        a.canThreePartsEqualSum(new int[]{6,1,1,13,-1,0,-10,20});
    }
}
