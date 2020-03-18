package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-18
 */
public class A_836_isRectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[1]>=rec2[3] || rec1[3]<=rec2[1] || rec1[2]<=rec2[0] || rec1[0]>=rec2[2])
            return false;
        return true;
    }

}
