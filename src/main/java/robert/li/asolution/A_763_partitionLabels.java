package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_763_partitionLabels {
    public static void main(String[] args) {
        String s = "caedbdedda";
        A_763_partitionLabels a_763_partitionLabels = new A_763_partitionLabels();
        List<Integer> integers = a_763_partitionLabels.partitionLabels(s);
    }
    public List<Integer> partitionLabels(String S) {
        char[] chars = S.toCharArray();
        int[] endIndex = new int[26];
        Arrays.fill(endIndex, -1);
        for (int i = chars.length - 1; i >= 0; i--) {
            if(endIndex[chars[i] - 'a'] == -1) {
                endIndex[chars[i] - 'a'] = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int i;
        int j = -1;
        while(j != chars.length - 1) {
            i = j + 1;
            int x = i;
            j = endIndex[chars[x] - 'a'];
            while(x < chars.length && x != j) {
                if(endIndex[chars[x] - 'a'] > j) {
                    j = endIndex[chars[x] - 'a'];
                }
                x++;
            }
            res.add(j - i + 1);
        }
        return res;
    }
}
