package robert.li;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-01
 */
public class A_373_kSmallestPairs {
    /**
     *
     *  nums1 个生序队列 取前k个最小
     *
     *  PriorityQueue底层实现： 二叉堆
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) return result;
        for (int i = 0; i < n1; i++) pq.offer(new int[]{i, 0});

        while(pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) pq.offer(new int[]{pair[0], pair[1]+1});
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }

        return result;
    }
}
