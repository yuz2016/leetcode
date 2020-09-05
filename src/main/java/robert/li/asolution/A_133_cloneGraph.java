package robert.li.asolution;

import java.util.*;

public class A_133_cloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(node.neighbors.size() == 0) ;
        Map<Integer, Node> map = new HashMap<>();
        Node dfs = dfs(node, map);
        Set<Integer> set = new HashSet<>();
        dfs1(node, set, map);
        return dfs;
    }

    Node dfs(Node node, Map<Integer, Node> map) {
        if(map.containsKey(node.val)) {
            return null;
        }
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            dfs(neighbor, map);
        }
        return newNode;
    }

    void dfs1(Node node, Set<Integer> set, Map<Integer, Node> map) {
        if(set.contains(node.val)) {
            return;
        }
        set.add(node.val);
        Node newNode = map.get(node.val);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            newNode.neighbors.add(map.get(neighbor.val));
            dfs1(neighbor, set, map);
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


