import java.util.LinkedList;
import java.util.Queue;

class ShortestDistance {
    int res;
    int[][] dirs;
    int m;
    int n;
    int oneCnt;
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        if (m == 0) return -1;
        n = grid[0].length;
        dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        oneCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneCnt++;
                }
            }
        }

        res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j, oneCnt);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int x, int y, int cnt) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (grid[cur[0]][cur[1]] == 1) {
                step += cur[2];
                cnt--;
                if (cnt == 0) {
                    break;
                }
                continue;
            }

            for (int i = 0; i < dirs.length; i++) {
                int nextX = cur[0] + dirs[i][0];
                int nextY = cur[1] + dirs[i][1];
                int nextStep = cur[2] + 1;

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] != 2) {
                    queue.offer(new int[]{nextX, nextY, nextStep});
                    visited[nextX][nextY] = true;
                }
            }
        }
        if (cnt == 0) {
            res = Math.min(res, step);
        }
    }
}