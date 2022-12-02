class HasValidPath {
    int m;
    int n;
    char[][] grid;
    boolean res;
    boolean[][][] visited;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        if (m == 0) return false;
        n = grid[0].length;
        this.grid = grid;
        res = false;
        visited = new boolean[m][n][(m + n + 1) / 2];

        if ((m + n) % 2 == 0) return false;

        if (grid[0][0] == ')') return false;
        if (grid[m - 1][n - 1] == '(') return false;

        dfs(0, 0, 0);
        return res;
    }

    private void dfs(int x, int y, int s) {
        if (s > m - x + n - y - 1) return;
        if (x == m - 1 && y == n - 1) {
            if (s == 1) {
                res = true;
                return;
            }
        }
        if (visited[x][y][s]) return;
        visited[x][y][s] = true;

        if (grid[x][y] == '(') {
            s++;
        } else {
            s--;
        }
        if (s < 0) return;

        if (x + 1 < m && !res) {
            dfs(x + 1, y, s);
        }
        if (y + 1 < n && !res) {
            dfs(x, y + 1, s);
        }
    }
}