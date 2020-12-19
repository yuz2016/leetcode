package robert.li.asolution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class A_659_isPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            // map不含 新建小根堆
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            // map含有x-1，x-1的小根堆中 以x-1结尾子序列长度最小的 出堆
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                // 因为 出堆造成堆空需移除该x-1 表示map里没有以x-1为结尾的子序列
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        // 便利所有子序列，如果对应小根堆堆顶 长度小于3 return false
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
