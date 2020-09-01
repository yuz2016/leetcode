package robert.li.asolution;

import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-08-31
 */
public class A_841_canVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        if(size <= 1) {
            return true;
        }
        boolean[] visited = new boolean[size];
        dfs(rooms, visited, 0);
        boolean res = true;
        for (boolean b : visited) {
            if(b == false) {
                res = false;
            }
        }
        return res;
    }

    void dfs(List<List<Integer>> rooms, boolean[] visited, int start) {
        visited[start] = true;
        List<Integer> list = rooms.get(start);
        for (Integer room : list) {
            if(visited[room]) {
                continue;
            }
            dfs(rooms, visited, room);
        }
    }
}
