package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/28
 */
public class A_278_firstBadVersion {
    public static void main(String[] args) {
        System.out.println((2 + 3) / 2);
        A_278_firstBadVersion a_278_firstBadVersion = new A_278_firstBadVersion();
        int i = a_278_firstBadVersion.firstBadVersion(3);
        System.out.println(i);
    }

    /**
     * 求平均值，要防止溢出的情况
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int i = 1;
        int j = n;
        int tmp = 0;
        while (i < j) {
            tmp = i + (j - i) / 2;
            if (isBadVersion(tmp)) {
                j = tmp;
            } else {
                i = tmp + 1;
            }
        }
        return i;
    }

    boolean isBadVersion(int n) {
        if (n >= 1) {
            return true;
        }
        return false;
    }

}
