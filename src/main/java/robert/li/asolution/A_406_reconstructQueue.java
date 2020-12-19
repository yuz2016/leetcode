package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        int[][] res = new int[length][2];

        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], -1);
        }
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < people.length; i++) {
            int count = 0;
            int countBefore = people[i][1];
            int j = 0;
            while(j < people.length) {
                if(res[j][0] == -1 || res[j][0] == people[i][0]) count++;
                if(count == countBefore + 1) {
                    res[j][0] = people[i][0];
                    res[j][1] = people[i][1];
                    break;
                }
                j++;
            }
        }
        return res;
    }

    public int[][] reconstructQueue1(int[][] people) {
        int length = people.length;
        int[][] res = new int[length][2];

        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[length][2]);
    }

}
