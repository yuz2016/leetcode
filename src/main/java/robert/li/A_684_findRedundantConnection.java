package robert.li;


/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-02-01
 */
public class A_684_findRedundantConnection {



    public static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int total) {
            parent = new int[total];
            rank = new int[total];

            for (int i = 0; i < total; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) {
                return;
            }

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        UnionFind unionFind = new UnionFind(edges.length);

        // 第一条边肯定未记录至树中，可直接合并节点
        unionFind.unionElements(edges[0][0] - 1, edges[0][1] - 1);
        for (int i = 1; i < edges.length; i++) {
            if (unionFind.find(edges[i][0] - 1) == unionFind.find(edges[i][1] - 1)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                unionFind.unionElements(edges[i][0] - 1, edges[i][1] - 1);
            }
        }
        return res;
    }


}
