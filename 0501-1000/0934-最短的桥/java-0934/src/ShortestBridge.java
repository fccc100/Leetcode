import java.util.LinkedList;
import java.util.Queue;

class ShortestBridge {

    int[][] dirs;
    int m;
    int n;
    public int shortestBridge(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;

        dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int id = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, id);
                    id++;
                }
            }
        }

        return bfs(grid);
    }

    private void dfs(int[][] grid, int x, int y, int id) {
        grid[x][y] = id;

        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];

            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && grid[nextX][nextY] == 1) {
                dfs(grid, nextX, nextY, id);
            }
        }
    }

    private int bfs(int[][] grid) {
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                int[] curPath = queue.poll();
                int curX = curPath[0];
                int curY = curPath[1];
                int curLen = curPath[2];

                for (int j = 0; j < dirs.length; j++) {
                    int nextX = curX + dirs[j][0];
                    int nextY = curY + dirs[j][1];

                    if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                        if (grid[nextX][nextY] == 3) {
                            return curLen;
                        }

                        if (!visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                            queue.offer(new int[]{nextX, nextY, curLen + 1});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}