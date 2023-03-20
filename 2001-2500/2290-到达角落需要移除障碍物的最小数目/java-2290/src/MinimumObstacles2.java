import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumObstacles2 {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int x = t[0];
            int y = t[1];
            int d = t[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int i = 0; i < dirs.length; i++) {
                int nextX = x + dirs[i][0];
                int nextY = y + dirs[i][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (d + grid[nextX][nextY] < dis[nextX][nextY]) {
                        dis[nextX][nextY] = d + grid[nextX][nextY];
                        pq.offer(new int[]{nextX, nextY, dis[nextX][nextY]});
                    }
                }
            }
        }

        return dis[m - 1][n - 1];
    }
}
