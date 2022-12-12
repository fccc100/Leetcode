import java.util.Arrays;

class MaxPoints {
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
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // 将grid元素转成一维数组并排序
        int mn = m * n;
        int[][] temp = new int[mn][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                temp[k][0] = grid[i][j];
                temp[k][1] = i;
                temp[k][2] = j;
            }
        }
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        // queries保存索引并排序
        int[][] tempQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            tempQueries[i][0] = queries[i];
            tempQueries[i][1] = i;
        }
        Arrays.sort(tempQueries, (a, b) -> a[0] - b[0]);

        // 设一指针i指向grid一维数组，对每一个query，只要当前grid元素小于query元素，就将其与相邻小于query的元素连接
        UnionFind uf = new UnionFind(mn);
        int[] res = new int[queries.length];
        int i = 0;
        for (int j = 0; j < tempQueries.length; j++) {
            while (i < temp.length && temp[i][0] < tempQueries[j][0]) {
                int x = temp[i][1];
                int y = temp[i][2];

                for (int k = 0; k < dirs.length; k++) {
                    int nextX = x + dirs[k][0];
                    int nextY = y + dirs[k][1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] < tempQueries[j][0]) {
                        uf.union(x * n + y, nextX * n + nextY);
                    }
                }
                i++;
            }

            // 小于当前query值的单元格已经全部连接了，如果左上角的值小于当前query值，结果就是0这个联通分量元素的个数
            if (grid[0][0] < tempQueries[j][0]) {
                res[tempQueries[j][1]] = uf.getComponentSize(0);
            }
        }
        return res;
    }
}
// grid = [
//  [1, 2, 3],
//  [2, 5, 7],
//  [3, 5, 1]
// ],
// queries = [5,6,2]

// [1, 1, 2, 2, 3, 3, 5, 5, 7]
// [2, 5, 6]
