package robert.li.asolution;

import java.util.Arrays;

public class A_1579_maxNumEdgesToRemove {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionSet unionSetA = new UnionSet(n + 1);
        UnionSet unionSetB = new UnionSet(n + 1);
        Arrays.sort(edges, (o1, o2) -> o2[0] - o1[0]);
        int num = 0;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if(edge[0] == 1) {
                boolean merge = unionSetA.merge(edge[1], edge[2]);
                if(!merge) {
                    num++;
                }
            }
            if(edge[0] == 2) {
                boolean merge = unionSetB.merge(edge[1], edge[2]);
                if(!merge) {
                    num++;
                }
            }
            if(edge[0] == 3) {
                boolean mergeA = unionSetA.merge(edge[1], edge[2]);
                boolean mergeB = unionSetB.merge(edge[1], edge[2]);
                if(!mergeA && !mergeB) {
                    num++;
                }
            }
        }
        return unionSetA.size == 2 && unionSetB.size == 2 ? num : -1;
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
