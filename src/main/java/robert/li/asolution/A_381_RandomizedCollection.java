package robert.li.asolution;

import java.util.*;

public class A_381_RandomizedCollection {

    /*
    val -》 {index1,index2}
     */
    Map<Integer, Set<Integer>> map;

    /*
    {val1,val2,val3...}
     */
    List<Integer> list;

    int index;

    public static void main(String[] args) {
        A_381_RandomizedCollection a_381_randomizedCollection = new A_381_RandomizedCollection();
        System.out.println(a_381_randomizedCollection.insert(0));
        System.out.println(a_381_randomizedCollection.insert(1));
        System.out.println(a_381_randomizedCollection.remove(0));
        System.out.println(a_381_randomizedCollection.insert(2));
        System.out.println(a_381_randomizedCollection.remove(1));
        System.out.println(a_381_randomizedCollection.getRandom());
    }

    /** Initialize your data structure here. */
    public A_381_RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        index = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if(!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(index);
        index++;
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        Set<Integer> set = map.get(val);
        Iterator<Integer> iterator = set.iterator();
        Integer curIndex = iterator.next();
        iterator.remove();
        // 覆盖操作
        Integer lastVal = list.get(index - 1);
        list.set(curIndex, lastVal);

        // 修改map
        if(curIndex != index - 1){
            Set<Integer> lastSet = map.get(lastVal);
            lastSet.remove(index - 1);
            lastSet.add(curIndex);
        }
        index--;
        list.remove(index);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if(index <= 0) throw new RuntimeException("空");
        int i = (int) Math.floor(Math.random() * index);
        return list.get(i);
    }
}
