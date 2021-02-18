package robert.li.asolution;

import java.util.HashSet;
import java.util.Set;

public class A_403_canCross {
    public boolean canCross(int[] stones) {
        return helper(stones, 0, 0, new HashSet<Integer>());
    }

    boolean helper(int[] stones, int index, int k, Set<Integer> set) {
        int key = index * 1000 + k;
        if(set.contains(key)) {
            return false;
        } else {
            set.add(key);
        }

        for(int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            if(gap >= k - 1 && gap <= k + 1) {
                if(helper(stones, i, gap, set) == true) return true;
            } else if(gap > k + 1) {
                break;
            } else {
                continue;
            }
        }
        if(index == stones.length - 1) return true;
        return false;
    }
}
