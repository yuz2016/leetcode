package robert.li.asolution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-08-27
 */
public class A_332_findItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 构造邻接链表
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> list = map.computeIfAbsent(ticket.get(0), i -> new LinkedList<>());
            list.add(ticket.get(1));
        }
        // 排序
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            entry.getValue().sort(String::compareTo);
        }
        // dfs
        String start = "JFK";
        List<String> list = new LinkedList<>();
        dfs(start, map, list);
        return list;
    }

    void dfs(String start, Map<String, List<String>> map, List<String> list) {
        List<String> e = map.get(start);
        while(e != null && e.size() != 0) {
            String remove = e.remove(0);
            dfs(remove, map, list);
        }
        list.add(0, start);
    }
}
