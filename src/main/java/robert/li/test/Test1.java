package robert.li.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/12
 */
public class Test1 {
    public static void main(String[] args) {
//        Iterable<Integer> integers = Arrays.asList(1,2,3,4);
        Iterable<Integer> integers = Lists.newArrayList();
        ArrayList<Integer> integers1 = Lists.newArrayList(Iterables.filter(integers, integer -> integer != 1));
        System.out.println(integers1.toString());
        int size = Iterables.size(integers);
        System.out.println("size:"+size);
        Integer last = Iterables.getLast(integers);
        System.out.println("last:"+last);
    }
}
