package robert.li.asolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_1202_smallestStringWithSwaps {
    public static void main(String[] args) {
        A_1202_smallestStringWithSwaps a_1202_smallestStringWithSwaps = new A_1202_smallestStringWithSwaps();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        lists.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        lists.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(2);
        lists.add(list3);
        a_1202_smallestStringWithSwaps.smallestStringWithSwaps("dcab", lists);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionSearchSet unionSearchSet = new UnionSearchSet(s.length());
        for (List<Integer> pair : pairs) {
            unionSearchSet.union(pair.get(0), pair.get(1));
        }
        int[] arr = unionSearchSet.arr;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int parent = unionSearchSet.findParent(i);
            if(map.containsKey(parent)) {
                map.get(parent).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(parent, list);
            }
        }
        char[] chars = s.toCharArray();
        for (List<Integer> value : map.values()) {
            sortSubList(value, chars);
        }
        return new String(chars);
    }

    public void sortSubList(List<Integer> value, char[] chars) {
        List<Character> list = new ArrayList<>();
        for (Integer integer : value) {
            list.add(chars[integer]);
        }
        list.sort(Character::compareTo);
        for (int i = 0; i < value.size(); i++) {
            chars[value.get(i)] = list.get(i);
        }
    }


    class UnionSearchSet {
        int[] arr;

        public UnionSearchSet(int size) {
            arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public int findParent(int x) {
            if(x == arr[x]) {
                return x;
            }
            return arr[x] = findParent(arr[x]);
        }

        public void union(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);
            if(parentX != parentY) {
                arr[parentY] = parentX;
            }
        }
    }
}
