package robert.li.asolution;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-18
 */
public class A_455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gl = g.length - 1;
        int sl = s.length - 1;
        int res = 0;
        while(gl >= 0 && sl >=0) {
            if(s[sl] >= g[gl]) {
                res++;
                sl--;
                gl--;
            } else {
                gl--;
            }
        }
        return res;
    }
}
