package robert.li.bsolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-25
 */
public class B_146_LRUCache {

    public static void main(String[] args) {
        B_146_LRUCache cache = new B_146_LRUCache( 2 /* 缓存容量 */ );

        cache.put(2, 1);
        cache.put(3, 2);
        cache.get(3);
        cache.get(2);
        cache.put(4, 3);
        cache.get(2);
        cache.get(3);
        cache.get(4);
    }

    Map<Integer, Node> map;
    int size = 0;
    NodeList nodeList;
    int capacity;

    public B_146_LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        nodeList = new NodeList();
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } else {
            nodeList.remove(node);
            nodeList.addHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)) {
            Node t = map.get(key);
            map.put(key, node);
            nodeList.remove(t);
            nodeList.addHead(node);
        } else {
            if(size < capacity) {
                map.put(key, node);
                nodeList.addHead(node);
                size++;
            } else {
                Node tail = nodeList.tail;
                nodeList.remove(tail);
                map.remove(tail.key);
                map.put(key, node);
                nodeList.addHead(node);
            }
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class NodeList {
        Node head = null;
        Node tail = null;

        void addHead(Node node) {
            if(head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        void remove(Node node) {

            if(head == tail) {
                head = tail = null;
            } else {
                if(node == tail) {
                    Node pre = node.pre;
                    node.pre = null;
                    pre.next = null;
                    tail = pre;
                } else if(node == head) {
                    Node next = node.next;
                    next.pre = null;
                    node.next = null;
                    head = next;
                } else {
                    Node pre = node.pre;
                    Node next = node.next;
                    next.pre = pre;
                    pre.next = next;
                    node.pre = null;
                    node.next = null;
                }
            }
        }
    }
}
