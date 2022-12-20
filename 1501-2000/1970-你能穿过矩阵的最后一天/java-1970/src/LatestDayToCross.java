import java.util.ArrayList;

class LatestDayToCross {
    // 5%
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
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += rank[pRoot];
            }
        }
    }

    public int latestDayToCross(int row, int col, int[][] cells) {

        int mn = row * col;
        int[][] grid = new int[row][col];
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = 1;
            }
        }

        UnionFind uf = new UnionFind(mn);
        ArrayList<Integer> firstRow = new ArrayList<>();
        ArrayList<Integer> lastRow = new ArrayList<>();
        for (int i = cells.length - 1; i >= 0; i--) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            int idx = x * col + y;
            grid[x][y] = 0;
            if (x == 0) {
                firstRow.add(idx);
            }
            if (x == row - 1) {
                lastRow.add(idx);
            }
            for (int j = 0; j < dirs.length; j++) {
                int nextX = x + dirs[j][0];
                int nextY = y + dirs[j][1];
                int nextIdx = nextX * col + nextY;
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid[nextX][nextY] == 0) {
                    uf.union(idx, nextIdx);
                }
            }

            for (Integer f : firstRow) {
                for (Integer l : lastRow) {
                    if (uf.isConnected(f, l)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}