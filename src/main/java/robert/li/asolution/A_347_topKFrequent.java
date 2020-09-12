package robert.li.asolution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-09-07
 */
public class A_347_topKFrequent {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        A_347_topKFrequent a_347_topKFrequent = new A_347_topKFrequent();
        a_347_topKFrequent.topKFrequent(ints, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] resArr = new int[k];
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(freq::get).reversed());
        pq.addAll(freq.keySet());
        for (int i = 0; i < k; i++) {
            resArr[i] = pq.remove();
        }
        return resArr;
    }
}
