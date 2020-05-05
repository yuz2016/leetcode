package robert.li.asolution;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-27
 */
public class A_914_hasGroupSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            int cur = map.getOrDefault(deck[i], 0) + 1;
            map.put(deck[i], cur);
        }

        Collection<Integer> values = map.values();
        int x = -1;
        for (Integer value : values) {
            if(x == -1) {
                x = value;
            } else {
                if(value < 2) return false;
                x = gcd(x, value);
                if(x == 1) return false;
            }

        }
        return true;
    }

    int gcd(int a, int b) {
        if( b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(2 % 3);
        System.out.println(3 % 2);
    }
}
