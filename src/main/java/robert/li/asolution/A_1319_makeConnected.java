package robert.li.asolution;

import java.util.Arrays;

public class A_1319_makeConnected {
    public static void main(String[] args) {
        A_1319_makeConnected a_1319_makeConnected = new A_1319_makeConnected();
        int i = a_1319_makeConnected.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {0, 3}});
    }

    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if(length < n - 1) {
            return -1;
        }
        UnionSet unionSet = new UnionSet(n);
        for (int i = 0; i < connections.length; i++) {
            unionSet.merge(connections[i][0], connections[i][1]);
        }
        return unionSet.size - 1;
    }

    class UnionSet {
        int[] arr;
        int[] dep;
        int size;

        public UnionSet(int n) {
            arr = new int[n];
            dep = new int[n];
            size = n;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            Arrays.fill(dep, 1);
        }

        public int find(int x) {
            if(x != arr[x]) {
                x = find(arr[x]);
            }
            return arr[x];
        }

        public void merge(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if(parentX == parentY) return;
            if(dep[parentX] < dep[parentY]) {
                int tmp = parentX;
                parentX = parentY;
                parentY = tmp;
            }
            arr[parentY] = parentX;
            if(dep[parentX] == dep[parentY]) {
                dep[parentX] += 1;
            }
            size--;
        }
    }
}
