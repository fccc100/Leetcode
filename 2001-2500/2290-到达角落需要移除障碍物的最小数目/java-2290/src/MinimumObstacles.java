import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MinimumObstacles {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];

            for (int i = 0; i < dirs.length; i++) {
                int nextX = x + dirs[i][0];
                int nextY = y + dirs[i][1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (dis[x][y] + grid[nextX][nextY] < dis[nextX][nextY]) {
                        dis[nextX][nextY] = dis[x][y] + grid[nextX][nextY];
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return dis[m - 1][n - 1];
    }
}