import java.util.Arrays;

class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            int cur = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                cur = Math.max(cur, grid[i][n - 1 - j]);
            }
            res += cur;
        }
        return res;
    }
}