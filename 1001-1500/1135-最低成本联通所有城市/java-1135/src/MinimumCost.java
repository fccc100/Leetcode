public class MinimumCost {

    class UnionFind {
        int[] parent;
        int[] size;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
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
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                rank[qRoot]++;
            }
        }
    }

    public int minimumCost(int n, int[][] connections) {
        int res = 0;
        int edgeCnt = 0;
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < connections.length; i++) {
            int v1 = connections[i][0];
            int v2 = connections[i][1];
            int w = connections[i][2];
            if (!uf.isConnected(v1, v2)) {
                res += w;
                edgeCnt++;
                uf.union(v1, v2);
            }
        }
        return edgeCnt < n - 1 ? -1 : res;
    }
}
