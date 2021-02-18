package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A_1584_minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;

        UnionSet unionSet = new UnionSet(length);
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int abs = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                list.add(new Line(i, j, abs));
            }
        }
        list.sort(Comparator.comparingInt(o -> o.length));
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            Line line = list.get(i);
            int parentA = unionSet.find(line.indexA);
            int parentB = unionSet.find(line.indexB);
            if(unionSet.range[parentA] == length || unionSet.range[parentB] == length) {
                break;
            }
            if(parentA == parentB) {
                continue;
            } else {
                unionSet.merge(parentA, parentB);
                res += line.length;
            }
        }
        return res;
    }

    public class Line {
        int indexA;
        int indexB;
        int length;

        public Line(int indexA, int indexB, int length) {
            this.indexA = indexA;
            this.indexB = indexB;
            this.length = length;
        }
    }



    public class UnionSet {
        int[] arr;
        int[] range;

        public UnionSet(int size) {
            this.arr = new int[size];
            this.range = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            Arrays.fill(range, 1);
        }

        public int find(int x) {
            if (arr[x] != x) {
                arr[x] = find(arr[x]);
            }
            return arr[x];
        }

        public void merge(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (range[parentX] <= range[parentY]) {
                arr[parentX] = parentY;
                range[parentY] += range[parentX];
            } else if(range[parentX] > range[parentY]) {
                arr[parentY] = parentX;
                range[parentX] += range[parentY];
            }
        }
    }
}
