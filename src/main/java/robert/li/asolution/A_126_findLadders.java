package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-07
 */
public class A_126_findLadders {
    public static void main(String[] args) {
        String[] s = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> strings = Arrays.asList(s);

        A_126_findLadders a = new A_126_findLadders();
        List<List<String>> ladders = a.findLadders("hit", "cog", strings);
        System.out.println(1);
    }
    int minCount;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        List<String> cur = new LinkedList<>();
        cur.add(beginWord);
        minCount = Integer.MAX_VALUE;
        helper(beginWord, endWord, wordList, visited, res, cur);
        return res;
    }

    void helper(String beginWord, String endWord, List<String> wordList, boolean[] visited, List<List<String>> res, List<String> cur) {
        if(cur.size() > minCount) return;
        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i]) continue;
            if (!canTransfer(beginWord, wordList.get(i))) continue;
            cur.add(wordList.get(i));
            visited[i] = true;
            if (wordList.get(i).equals(endWord)) {
                if (cur.size() < minCount) {
                    res.clear();
                    res.add(new LinkedList<>(cur));
                    minCount = cur.size();
                } else if (cur.size() == minCount) {
                    res.add(new LinkedList<>(cur));
                }
            } else {
                helper(wordList.get(i), endWord, wordList, visited, res, cur);
            }
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }

    boolean canTransfer(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int count = 0;
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                count++;
            }
        }
        return count == 1;
    }

    // bfs
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        // 结果集
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        // 字典中不包含目标单词
        if (!distSet.contains(endWord)) {
            return res;
        }
        // 已经访问过的单词集合：只找最短路径，所以之前出现过的单词不用出现在下一层
        Set<String> visited = new HashSet<>();
        // 累积每一层的结果队列
        Queue<List<String>> queue= new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(list);
        visited.add(beginWord);
        // 是否到达符合条件的层：如果该层添加的某一单词符合目标单词，则说明截止该层的所有解为最短路径，停止循环
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            // 上一层的结果队列
            int size = queue.size();
            // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
            // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
            // 如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                // 获取该路径上一层的单词
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();
                // 寻找该单词的下一个符合条件的单词
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = new String(chars);
                        // 符合条件：在 wordList 中 && 之前的层没有使用过
                        if (distSet.contains(str) && !visited.contains(str)) {
                            // 生成新的路径
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            // 如果该单词是目标单词：将该路径添加到结果集中，查询截止到该层
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                            // 将该路径添加到该层队列中
                            queue.add(pathList);
                            // 将该单词添加到该层已访问的单词集合中
                            subVisited.add(str);
                        }
                    }
                    chars[j] = temp;
                }
            }
            // 将该层所有访问的单词添加到总的已访问集合中
            visited.addAll(subVisited);
        }
        return res;
    }

}
