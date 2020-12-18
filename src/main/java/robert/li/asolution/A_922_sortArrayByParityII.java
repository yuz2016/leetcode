package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-11-12
 */
public class A_922_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] a) {
        // 偶数在奇数位置
        int i = 0;
        // 奇数在偶数位置
        int j = 0;
        while(i < a.length && j < a.length) {
            while(i < a.length) {
                if(a[i] % 2 == 0 && i % 2 == 1) {
                    break;
                }
                i++;
            }
            while(j < a.length) {
                if(a[j] % 2 == 1 && j % 2 == 0) {
                    break;
                }
                j++;
            }
            if(i < a.length && j < a.length) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j++;
            }
        }
        return a;
    }
}
