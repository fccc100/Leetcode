import java.util.LinkedList;
import java.util.Queue;

class HasPath {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if (m == 0) return false;
        int n = maze[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curV = queue.poll();

            if (curV[0] == destination[0] && curV[1] == destination[1]) {
                return true;
            }

            for (int i = 0; i < dirs.length; i++) {
                int nextX = curV[0] + dirs[i][0];
                int nextY = curV[1] + dirs[i][1];

                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX][nextY] == 0) {
                    nextX += dirs[i][0];
                    nextY += dirs[i][1];
                }

                if (!visited[nextX - dirs[i][0]][nextY - dirs[i][1]]) {
                    queue.offer(new int[]{nextX - dirs[i][0], nextY - dirs[i][1]});
                    visited[nextX - dirs[i][0]][nextY - dirs[i][1]] = true;
                }
            }
        }
        return false;
    }
}