package robert.li.asolution;

import java.util.*;

public class A_778_swimInWater {

    public int swimInWater(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        if(m == 1 && n == 1) return 0;
        Map<Integer, List<Model>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map.containsKey(heights[i][j])) {
                    map.get(heights[i][j]).add(new Model(i, j, heights[i][j]));
                } else {
                    List<Model> tmpList = new ArrayList<>();
                    tmpList.add(new Model(i, j, heights[i][j]));
                    map.put(heights[i][j], tmpList);
                }
            }
        }
        UnionSet unionSet = new UnionSet(m * n);
        int i = 0;
        while (true) {
            List<Model> tmpList = map.get(i);
            for (int j = 0; j < tmpList.size(); j++) {
                Model model = tmpList.get(j);
                int x = model.x;
                int y = model.y;
                if (x > 0 && heights[x][y] >= heights[x - 1][y]) {
                    unionSet.merge(x * n + y, (x - 1) * n + y);
                }
                if (x < m - 1 && heights[x][y] >= heights[x + 1][y]) {
                    unionSet.merge(x * n + y, (x + 1) * n + y);
                }
                if (y > 0 && heights[x][y] >= heights[x][y - 1]) {
                    unionSet.merge(x * n + y, x * n + y - 1);
                }
                if (y < n - 1 && heights[x][y] >= heights[x][y + 1]) {
                    unionSet.merge(x * n + y, x * n + y + 1);
                }
            }


            if(unionSet.find(0) == unionSet.find(m * n - 1)) {
                return i;
            }
            i++;
        }
    }

    class Model {
        int x;
        int y;
        int value;

        public Model(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }


    class UnionSet {
        int[] arr;
        int[] range;
        int size;

        public UnionSet(int size) {
            arr = new int[size];
            range = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            Arrays.fill(range, 1);
            this.size = size;
        }

        int find(int x) {
            if(arr[x] != x) {
                arr[x] = find(arr[x]);
            }
            return arr[x];
        }

        boolean merge(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if(parentX == parentY) {
                return false;
            }
            if(range[parentY] < range[parentX]) {
                int tmp = parentX;
                parentX = parentY;
                parentY = tmp;
            }
            arr[parentX] = parentY;
            if(range[parentX] == range[parentY]) {
                range[parentY]++;
            }
            size--;
            return true;
        }
    }
}
