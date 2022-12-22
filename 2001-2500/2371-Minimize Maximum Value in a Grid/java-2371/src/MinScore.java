import java.util.List;

import java.util.ArrayList;

class MinScore {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<int[]> items = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                items.add(new int[]{i, j});
            }
        }
        items.sort((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] item : items) {
            int x = item[0];
            int y = item[1];
            int v = Math.max(rows[x], cols[y]) + 1;
            grid[x][y] = v;
            rows[x] = v;
            cols[y] = v;
        }
        return grid;
    }
}