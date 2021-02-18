package robert.li.asolution;

public class A_803_hitBricks {
    //行列
    private int m, n;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.m = grid.length;
        this.n = grid[0].length;
        //拷贝数组
        int[][] copy = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                copy[i][j] = grid[i][j];
        }
        //把copy中的数组砖头全部击碎
        //先敲后补
        for(int[] hit : hits)
            copy[hit[0]][hit[1]] = 0;

        //构建敲碎之后的并查集
        //parent[size]用来表示天花板
        int size = m * n;
        UnionFindSet unionFindSet = new UnionFindSet(size + 1);
        //第0行 直接与屋顶相连
        for(int j = 0; j < n; j++){
            if(copy[0][j] == 1)
                unionFindSet.union(getIndex(0, j), size);
        }
        //第1 2 3 ...m行
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(copy[i][j] == 1) {
                    //向上连通
                    if((i - 1) >= 0 && copy[i - 1][j] == 1)
                        unionFindSet.union(getIndex(i, j), getIndex(i - 1, j));
                    //向左连通
                    if((j - 1) >= 0 && copy[i][j - 1] == 1)
                        unionFindSet.union(getIndex(i, j), getIndex(i, j - 1));
                }
            }
        }

        //按照hits逆序连通
        int len = hits.length;
        int[] res = new int[len];
        for(int i = len - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            //如果原来就是空白
            //敲与补都不会掉落
            if(grid[x][y] == 0)
                continue;
            //当前块敲完之后的与屋顶相连的节点数量
            int count2 = unionFindSet.getSize(size);
            //第0行的向上连通的特殊处理
            if(x == 0)
                unionFindSet.union(getIndex(0, y), size);
            //上下左右连通
            if((x - 1) >= 0 && copy[x - 1][y] == 1)
                unionFindSet.union(getIndex(x, y), getIndex(x - 1, y));
            if((x + 1) < m && copy[x + 1][y] == 1)
                unionFindSet.union(getIndex(x, y), getIndex(x + 1, y));
            if((y - 1) >= 0 && copy[x][y - 1] == 1)
                unionFindSet.union(getIndex(x, y), getIndex(x, y - 1));
            if((y + 1) < n && copy[x][y + 1] == 1)
                unionFindSet.union(getIndex(x, y), getIndex(x, y + 1));
            //当前块敲完之前与屋顶的节点数量
            int count1 = unionFindSet.getSize(size);
            res[i] = Math.max(0, count1 - count2 - 1);
            //补上
            copy[x][y] = 1;
        }
        return res;
    }

    //二维坐标转一维索引
    public int getIndex(int x, int y) {
        return x * n + y;
    }

    //并查集
    //路径压缩
    public class UnionFindSet {
        private int n;
        private int[] parent;
        //以当前节点为根节点的子树的的节点总数
        private int[] size;
        public UnionFindSet(int n) {
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];
            //初始化
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        //找到x的根节点
        public int find(int x) {
            if(x == parent[x])
                return x;
            //路径压缩
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int index1 = find(x), index2 = find(y);
            if(index1 == index2)
                return;
            parent[index1] = index2;
            size[index2] += size[index1];
        }

        //以x为根结点的子树包含的结点总数
        public int getSize(int x) {
            int index = find(x);
            return size[index];
        }
    }
}
