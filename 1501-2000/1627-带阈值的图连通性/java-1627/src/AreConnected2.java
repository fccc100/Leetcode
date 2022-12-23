import java.util.List;

import java.util.ArrayList;

class AreConnected2 {
    class UnionFind {
        int[] parent;
        int[] rank;
        int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
                size[i] = 1;
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
                size[qRoot] += size[pRoot];
            } else if (rank[qRoot] < rank[pRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
                size[qRoot] += size[pRoot];
            }
        }

        public int getComponentSize(int p) {
            return size[find(p)];
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n + 1);
        // 针对每个质因数i，连接(i,2i), (2i,3i), (3i,4i)...
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i, k = i * 2; k <= n; j += i, k += i) {
                uf.union(j, k);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(uf.isConnected(queries[i][0], queries[i][1]));
        }
        return res;
    }
}