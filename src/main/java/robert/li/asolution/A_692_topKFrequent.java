package robert.li.asolution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-01
 */
public class A_692_topKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1).equals(map.get(s2))) {
                    return s2.compareTo(s1);
                }
                return map.get(s1).compareTo(map.get(s2));
            }
        });

        for (String key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (queue.comparator().compare(key, queue.peek()) > 0) {
                queue.poll();
                queue.add(key);
            }
        }

        String[] res = new String[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }

        return Arrays.asList(res);
    }
}
