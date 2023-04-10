import java.util.LinkedList;
import java.util.Queue;

class MinimumVisitedCells {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            int d = cur[2];

            if (i == m - 1 && j == n - 1) return d;

            for (int k = Math.min(n - 1, grid[i][j] + j); k >= j + 1; k--) {
                if (!visited[i][k]) {
                    visited[i][k] = true;
                    queue.offer(new int[]{i, k, d + 1});
                }
            }
            for (int k = Math.min(m - 1, grid[i][j] + i); k >= i + 1; k--) {
                if (!visited[k][j]) {
                    visited[k][j] = true;
                    queue.offer(new int[]{k, j, d + 1});
                }
            }
        }
        return -1;
    }
}