import java.util.ArrayList;
import java.util.HashMap;

class LargestArea {
    int[][] dirs;
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

        public int getCount(char[][] grid, int m, int n) {
            int res = 0;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int root = find(i);
                int x = i / n;
                int y = i % n;
                if (grid[x][y] == '0') continue;
                if (!map.containsKey(root)) {
                    map.put(root, new ArrayList<>());
                }
                map.get(root).add(i);
            }
            for (ArrayList<Integer> g : map.values()) {
                int size = g.size();
                boolean isMatched = true;
                for (int i = 0; i < size; i++) {
                    int idx = g.get(i);
                    int x = idx / n;
                    int y = idx % n;
                    if (grid[x][y] == '0') {
                        isMatched = false;
                        break;
                    }
                    for (int j = 0; j < dirs.length; j++) {
                       int nextX = x + dirs[j][0];
                       int nextY = y + dirs[j][1];
                        if (nextX < 0 || nextY < 0 || nextX > m - 1 || nextY > n - 1 || grid[nextX][nextY] == '0') {
                            isMatched = false;
                            break;
                        }
                    }
                    if (!isMatched) break;
                }
                if (isMatched) {
                    res = Math.max(res, size);
                }
            }
            return res;
        }
    }

    public int largestArea(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid[i].charAt(j);
            }
        }

        int mn = m * n;
        UnionFind uf = new UnionFind(mn);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                int curIdx = i * n + j;

                for (int k = 0; k < dirs.length; k++) {
                    int nextX = i + dirs[k][0];
                    int nextY = j + dirs[k][1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] == matrix[i][j]) {
                        int nextIdx = nextX * n + nextY;
                        uf.union(curIdx, nextIdx);
                    }
                }
            }
        }
        return uf.getCount(matrix, m, n);
    }
}