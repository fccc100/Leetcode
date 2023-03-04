
// 状态压缩
class UniquePathsIII2 {
    int m, n;
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] grid;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int visited = 0;

        int start = -1, end = -1;
        int left = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start = i * n + j;
                    grid[i][j] = 0;
                }
                else if (grid[i][j] == 2) {
                    end = i * n + j;
                    grid[i][j] = 0;
                }
                else if (grid[i][j] == -1) left--;
            }
        }

        return dfs(visited, start, end, left);
    }
    private int dfs(int visited, int v, int end, int left) {
        int x = v / n;
        int y = v % n;
        // v变成1
        visited |= (1 << v);
        left--;
        if (left == 0 && v == end) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            int nextV = nextX * n + nextY;
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && grid[nextX][nextY] == 0 && (visited & (1 << nextV)) == 0) {
                res += dfs(visited, nextV, end, left);
            }
        }

        return res;
    }
}