import java.util.Arrays;

class DistanceLimitedPathsExist {
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) return;
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // 將queries按limit從小到大排序
        int[][] temp = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++) {
            temp[i][0] = queries[i][0];
            temp[i][1] = queries[i][1];
            temp[i][2] = queries[i][2];
            temp[i][3] = i;
        }
        Arrays.sort(temp, (a, b) -> a[2] - b[2]);

        // 将每条边按limit从小到大排序
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);

        // 用指针i指向第一条边，对每个query，只要当前两条边之间的limit还小于当前查询的limit，就将这两条边连接
        // 此时这个query的答案就是这个query的两条边是否联通
        int i = 0;
        boolean[] res = new boolean[temp.length];
        for (int j = 0; j < temp.length; j++) {
            while (i < edgeList.length && edgeList[i][2] < temp[j][2]) {
                uf.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            res[temp[j][3]] = uf.isConnected(temp[j][0], temp[j][1]);
        }
        return res;
    }
}

