package robert.li;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-05
 */
public class A_460_LFUCache {

    Map<Integer, Node> map = new HashMap<>();
    DoubleList[] doubleLists;
    int size = 0;
    int capacity;

    public A_460_LFUCache(int capacity) {
        doubleLists = new DoubleList[1000];
        this.capacity = capacity;
        for (int i = 0; i < doubleLists.length; i++) {
            doubleLists[i] = new DoubleList();
        }
    }

    public int get(int key) {
        int value;
        if(!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            // 删除old  frequency doubleLists 节点
            int frequency = node.frequency;
            DoubleList doubleList = doubleLists[frequency];
            doubleList.remove(node);

            // 添加到 new frequency doubleLists 节点
            frequency = frequency + 1;
            DoubleList doubleList1 = doubleLists[frequency];
            node.frequency = frequency;
            doubleList1.addFirst(node);
            value = node.val;
        }
        return value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value, 1);
        // key存在，更新访问次数，更新值
        if (map.containsKey(key)) {
            // 删除旧节点
            Node old = map.get(key);
            int frequency = old.frequency;
            DoubleList doubleList = doubleLists[frequency];
            doubleList.remove(old);
            // 添加新节点
            frequency = frequency + 1;
            node.frequency = frequency;
            DoubleList doubleList1 = doubleLists[frequency];
            doubleList1.addFirst(node);
            map.put(key, node);
        } else {
            if (size == capacity) {
                for (int i = 0; i < doubleLists.length; i++) {
                    if(doubleLists[i].size > 0) {
                        Node node1 = doubleLists[i].removeLast();
                        map.remove(node1.key);
                        break;
                    }
                }
            }
            if(size < capacity) {
                DoubleList doubleList = doubleLists[1];
                doubleList.addFirst(node);
                map.put(key, node);
                size++;
            }
        }
    }

    class Node {
        public int key, val, frequency;
        public Node next, prev;

        public Node(int k, int v, int frequency) {
            this.key = k;
            this.val = v;
            this.frequency = frequency;
        }
    }

    class DoubleList {
        private Node head, tail; // 头尾虚节点
        private int size; // 链表元素数

        public DoubleList() {
            head = new Node(0, 0, 0);
            tail = new Node(0, 0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() {
            return size;
        }
    }
}




