class Largest1BorderedSquare {
    // 5%
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxEdge = Math.min(m - i, n - j);

                for (int k = 0; k <= maxEdge; k++) {
                    if (check(grid, i, j, k)) {
                        res = Math.max(res, k * k);
                    }
                }
            }
        }
        return res;
    }

    private boolean check(int[][] grid, int x, int y, int k) {
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (i == x || j == y || i == x + k - 1 || j == y + k - 1) {
                    if (grid[i][j] != 1) return false;
                }
            }
        }
        return true;
    }
}

// [
//  [1, 1, 1],
//  [1, 0, 1],
//  [1, 1, 1]
// ]