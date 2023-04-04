import java.util.LinkedList;
import java.util.Queue;

class CountUnguarded {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < guards.length; i++) {
            grid[guards[i][0]][guards[i][1]] = 1;
        }
        for (int i = 0; i < walls.length; i++) {
            grid[walls[i][0]][walls[i][1]] = -1;
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < dirs.length; k++) {
                        int nextX = i + dirs[k][0];
                        int nextY = j + dirs[k][1];
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0) {
                            queue.offer(new int[]{nextX, nextY, k});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int[] dir = dirs[cur[2]];
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0) {
                queue.offer(new int[]{nextX, nextY, cur[2]});
                visited[nextX][nextY] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) res++;
            }
        }
        return res;
    }
}