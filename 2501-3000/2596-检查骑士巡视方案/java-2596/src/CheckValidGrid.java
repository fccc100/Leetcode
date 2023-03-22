class CheckValidGrid {
    int m;
    int n;
    int[][] dirs;
    public boolean checkValidGrid(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        return check(grid, 0, 0, 0);
    }
    private boolean check(int[][] grid, int i, int j, int val) {
        if (i < 0 || i >= m) return false;
        if (j < 0 || j >= n) return false;
        if (grid[i][j] != val) return false;
        if (val == m * n - 1) return true;

        boolean res = false;
        for (int k = 0; k < dirs.length; k++) {
            res |= check(grid, i + dirs[k][0], j + dirs[k][1], val + 1);
        }
        return res;
    }
}