import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class ConveyorBelt {
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int m = matrix.length;
        int n = matrix[0].length();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i].charAt(j);
                if (c == '>') {
                    grid[i][j] = 1;
                } else if (c == '<') {
                    grid[i][j] = 2;
                } else if (c == 'v') {
                    grid[i][j] = 3;
                } else if (c == '^') {
                    grid[i][j] = 4;
                }
            }
        }

        return minCost(grid, start, end);
    }

    private int minCost(int[][] grid, int[] start, int[] end) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[m][n];

        dis[start[0]][start[1]] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int x = t[0];
            int y = t[1];
            int d = t[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;
            int v = grid[x][y];
            int curDir = v - 1;

            for (int i = 0; i < dirs.length; i++) {
                int nextX = x + dirs[i][0];
                int nextY = y + dirs[i][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (curDir == i) {
                        if (d + 0 < dis[nextX][nextY]) {
                            dis[nextX][nextY] = d + 0;
                            pq.offer(new int[]{nextX, nextY, d + 0});
                        }
                    } else {
                        if (d + 1 < dis[nextX][nextY]) {
                            dis[nextX][nextY] = d + 1;
                            pq.offer(new int[]{nextX, nextY, d + 1});
                        }
                    }
                }
            }
        }

        return dis[end[0]][end[1]];
    }
}