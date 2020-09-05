package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-16
 */
public class A_785_isBipartite {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        for (int i = 0; i < color.length; i++) {
            if(color[i] != 0) {
                continue;
            }
            Deque<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            while(!queue.isEmpty()) {
                Integer poll = queue.poll();
                int curColor = color[poll] == 1 ? -1 : 1;
                for (int j = 0; j < graph[poll].length; j++) {
                    int adj = graph[poll][j];
                    if(color[adj] == 0) {
                        color[adj] = curColor;
                        queue.add(adj);
                    } else if(color[adj] != curColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
