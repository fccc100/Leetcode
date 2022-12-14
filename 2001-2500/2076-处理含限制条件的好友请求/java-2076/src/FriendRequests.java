class FriendRequests {
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
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);

        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int x = requests[i][0];
            int y = requests[i][1];
            if (uf.isConnected(x, y)) {
                res[i] = true;
                continue;
            }

            boolean isMatch = false;
            for (int j = 0; j < restrictions.length; j++) {
                int x1 = restrictions[j][0];
                int y1 = restrictions[j][1];
                if ((uf.isConnected(x, x1) && uf.isConnected(y, y1)) || (uf.isConnected(x, y1) && uf.isConnected(y, x1))) {
                    isMatch = true;
                    break;
                }
            }
            if (isMatch) {
                res[i] = false;
            } else {
                res[i] = true;
                uf.union(x, y);
            }
        }
        return res;
    }
}
