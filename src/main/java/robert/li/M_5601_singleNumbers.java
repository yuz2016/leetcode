package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-28
 */
public class M_5601_singleNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,3};
        M_5601_singleNumbers m_5601_singleNumbers = new M_5601_singleNumbers();
        int[] ints = m_5601_singleNumbers.singleNumbers(arr);
        System.out.println(Arrays.toString(ints));
        System.out.println((3 ^ 2));
    }

    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int indexFromLast = get1IndexFromLast(tmp);
        int zero = 0;
        int one = 0;
        for (int i = 0; i < nums.length; i++) {
            if(isOneByIntIndex(nums[i], indexFromLast)) {
                one = one ^ nums[i];
            } else {
                zero ^= nums[i];
            }
        }
        return new int[]{one, zero};
    }

    private int get1IndexFromLast(int tmp) {
        int i = 0;
        while((tmp & 1) == 0) {
            tmp >>= 1;
            i++;
        }
        return i;
    }

    private boolean isOneByIntIndex(int tmp, int index) {
        int i = 1;
        while(index > 0) {
            i <<= 1;
            index--;
        }
        return (tmp & i) != 0;
    }
}
