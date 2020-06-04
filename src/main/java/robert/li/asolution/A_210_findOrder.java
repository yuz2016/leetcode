package robert.li.asolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-17
 */
public class A_210_findOrder {
    public static void main(String[] args) {
        A_210_findOrder a = new A_210_findOrder();
//        a.findOrder2(3, new int[][]{{0,1},{0,2},{1,2}});
        int[] order = a.findOrder(2, new int[][]{{1, 0}});
        int i = 0;
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preIn = new int[numCourses];
        HashSet<Integer>[] indexToSet = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indexToSet[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            preIn[prerequisites[i][0]] += 1;
            indexToSet[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(preIn[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[count] = poll;
            count++;
            HashSet<Integer> integers = indexToSet[poll];
            for (Integer i : integers) {
                preIn[i] -= 1;
                if(preIn[i] == 0) {
                    queue.add(i);
                }
            }
        }
        if(count == numCourses) return res;
        return new int[0];
    }



    // 循环检测有问题
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();// 0->1,2
        Set<Integer> someIn = new HashSet<>();// x -> 1 , 1 in someIn
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> set = map.getOrDefault(prerequisites[i][1], new HashSet<>());
            set.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], set);
            someIn.add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[numCourses];// 已访问节点层级
        int level = 1;
        for (int i = 0; i < numCourses; i++) {
            if(!someIn.contains(i)) {
                queue.add(i);
                visited[i] = level;
            }
        }
        if(queue.isEmpty()) return new int[0];
        int[] res = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer poll = queue.poll();
                res[i] = poll;
                i++;
                if(map.containsKey(poll)) {
                    Set<Integer> integerSet = map.get(poll);
                    for (Integer index : integerSet) {
                        // 循环检测
                        if(visited[index] != 0 && visited[index] < level) {
                            return new int[0];
                        }
                        if(visited[index] == 0) {
                            queue.add(index);
                            visited[index] = level;
                        }
                    }
                }
            }
        }
        return res;
    }
}
