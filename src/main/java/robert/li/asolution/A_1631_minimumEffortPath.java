package robert.li.asolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A_1631_minimumEffortPath {

    public static void main(String[] args) {
        A_1631_minimumEffortPath a_1631_minimumEffortPath = new A_1631_minimumEffortPath();
        a_1631_minimumEffortPath.minimumEffortPath(new int[][] {{4,3,4,10,5,5,9,2},
                {10, 8, 2, 10, 9, 7, 5, 6}, {5,8,10,10,10,7,4,2},
                {5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}});
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        if(m == 1 && n == 1) return 0;
        List<Model> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n - 1) {
                    int absRight = Math.abs(heights[i][j] - heights[i][j + 1]);
                    list.add(new Model(i * n + j, i * n + j + 1, absRight));
                }
                if(i < m - 1) {
                    int absDown = Math.abs(heights[i][j] - heights[i + 1][j]);
                    list.add(new Model(i * n + j, (i + 1) * n + j, absDown));
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o.abs));
        UnionSet unionSet = new UnionSet(m * n);
        for (int i = 0; i < list.size(); i++) {
            Model model = list.get(i);
            unionSet.merge(model.x, model.y);
            if(unionSet.find(0) == unionSet.find(m * n - 1)) {
                return model.abs;
            }
        }
        return -1;
    }

    class Model {
        int x;
        int y;
        int abs;

        public Model(int x, int y, int abs) {
            this.x = x;
            this.y = y;
            this.abs = abs;
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
