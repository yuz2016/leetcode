package robert.li.bsolution;

import java.util.Arrays;

public class B_455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < g.length && j < s.length) {
            while(j < s.length && g[i] > s[j]) {
                j++;
            }
            if(j != s.length) {
                count++;
                j++;
                i++;
            }
        }
        return count;
    }
}
