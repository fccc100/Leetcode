class MinPathCost {

    // TLE
    int m;
    int n;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dfs(grid, 0, i, moveCost));
        }
        return res;
    }
    private int dfs(int[][] grid, int x, int y, int[][] moveCost) {
        if (x == m - 1) return grid[x][y];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, grid[x][y] + moveCost[grid[x][y]][i] + dfs(grid, x + 1, i, moveCost));
        }
        return res;
    }
}