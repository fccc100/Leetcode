class FindRedundantConnection {
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            parent[pRoot] = qRoot;
        }
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        int[] res = new int[2];
        for (int i = 0; i < edges.length; i++) {
            if (!uf.isConnected(edges[i][0], edges[i][1])) {
                uf.union(edges[i][0], edges[i][1]);
            } else {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
        }
        return res;
    }
}