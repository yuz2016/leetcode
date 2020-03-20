package robert.li;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-20
 */
public class M_40_getLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k < 1) return new int[0];
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if(i < k) {
                bigHeap.add(arr[i]);
            } else {
                if(!bigHeap.isEmpty() && bigHeap.peek() < arr[i]) {
                    bigHeap.poll();
                    bigHeap.add(arr[i]);
                }
            }
        }
        int[] res = new int[bigHeap.size()];
        Integer[] integers = bigHeap.toArray(new Integer[0]);
        for (int i = 0; i < integers.length; i++) {
            res[i] = integers[i];
        }
        return res;
    }
}
