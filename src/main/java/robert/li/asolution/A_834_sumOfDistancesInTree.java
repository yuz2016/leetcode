package robert.li.asolution;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-10-06
 */
public class A_834_sumOfDistancesInTree {
    ArrayList<HashSet<Integer>> graph;
    int[] res;
    int[] count;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        res = new int[N];
        count = new int[N];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        helper(0, -1);
        helper2(0, -1);
        return res;
    }

    void helper(int root, int pre) {
        HashSet<Integer> neighbor = graph.get(root);
        for (int n : neighbor) {
            if (n == pre) continue;
            helper(n, root);
            count[root] += count[n];
            res[root] += res[n] + count[n];
        }
        count[root]++;
    }

    void helper2(int root, int pre) {
        HashSet<Integer> neighbor = graph.get(root);
        for (int n : neighbor) {
            if (n == pre) continue;
            res[n] = res[root] - count[n] + count.length - count[n];
            helper2(n, root);
        }
    }
}
