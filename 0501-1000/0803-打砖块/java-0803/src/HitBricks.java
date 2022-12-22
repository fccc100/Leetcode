class HitBricks {
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
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = m * n;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < hits.length; i++) {
            grid[hits[i][0]][hits[i][1]] = 0;
        }

        UnionFind uf = new UnionFind(mn + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int idx = i * n + j;
                    if (i == 0) {
                        uf.union(idx, mn);
                    }
                    for (int k = 0; k < dirs.length; k++) {
                        int nextX = i + dirs[k][0];
                        int nextY = j + dirs[k][1];
                        int nextIdx = nextX * n + nextY;
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                            uf.union(idx, nextIdx);
                        }
                    }
                }
            }
        }

        int[] res = new int[hits.length];
        int lastSize = uf.getComponentSize(mn);
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (temp[x][y] == 0) {
                res[i] = 0;
                continue;
            }
            grid[x][y] = 1;

            int idx = x * n + y;
            if (x == 0) {
                uf.union(idx, mn);
            }
            for (int j = 0; j < dirs.length; j++) {
                int nextX = x + dirs[j][0];
                int nextY = y + dirs[j][1];
                int nextIdx = nextX * n + nextY;

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                    uf.union(idx, nextIdx);
                }
            }
            int size = uf.getComponentSize(mn);
            res[i] = Math.max(0, size - lastSize - 1);
            lastSize = size;
        }
        return res;
    }
}