class MaxNumEdgesToRemove {
    class UnionFind {
        int[] parent;
        int[] rank;
        int cnt;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            cnt = n - 1;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
                parent[p] = parent[parent[p]];
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
                parent[pRoot] = parent[qRoot];
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = parent[pRoot];
            } else {
                parent[pRoot] = parent[qRoot];
                rank[qRoot] += rank[pRoot];
            }
            cnt--;
        }
        public int getCnt() {
            return cnt;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufA = new UnionFind(n + 1);
        UnionFind ufB = new UnionFind(n + 1);
        int unionCnt = 0;
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            int v1 = edges[i][1];
            int v2 = edges[i][2];
            if (type == 3) {
                if (!ufA.isConnected(v1, v2)) {
                    ufA.union(v1, v2);
                    ufB.union(v1, v2);
                    unionCnt++;
                }
                if (ufA.getCnt() == 1) {
                    return edges.length - unionCnt;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            int v1 = edges[i][1];
            int v2 = edges[i][2];
            if (type == 1) {
                if (!ufA.isConnected(v1, v2)) {
                    ufA.union(v1, v2);
                    unionCnt++;
                }
            }
            if (type == 2) {
                if (!ufB.isConnected(v1, v2)) {
                    ufB.union(v1, v2);
                    unionCnt++;
                }
            }
        }
        if (ufA.getCnt() > 1 || ufB.getCnt() > 1) return -1;
        return edges.length - unionCnt;
    }
}