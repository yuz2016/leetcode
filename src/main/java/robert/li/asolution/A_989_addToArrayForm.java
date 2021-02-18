package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

public class A_989_addToArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ks = new ArrayList<>();
        while(K != 0) {
            int cur = K % 10;
            K = K / 10;
            ks.add(0, cur);
        }
        List<Integer> res = new ArrayList<>();
        int i = A.length - 1;
        int j = ks.size() - 1;
        int next = 0;
        while(i >= 0 || j >= 0) {
            int a = 0;
            if(i >= 0) {
                a = A[i];
                i--;
            }

            int b = 0;
            if(j >= 0) {
                b = ks.get(j);
                j--;
            }

            int cur = a + b + next;
            next = cur / 10;
            cur = cur % 10;
            res.add(0, cur);
        }
        if(next != 0) {
            res.add(0, next);
        }
        return res;
    }
}
