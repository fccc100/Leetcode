import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MinCost {
    // TLE
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        if (startPos[0] == homePos[0] && startPos[1] == homePos[1]) return 0;
        int m = rowCosts.length;
        int n = colCosts.length;
        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startPos[0], startPos[1], 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int curCost = cur[2];

            for (int i = 0; i < dirs.length; i++) {
                int nextX = x + dirs[i][0];
                int nextY = y +dirs[i][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    // 上下移动
                    if (nextX != x) {
                        int cost = rowCosts[nextX];
                        if (curCost + cost < costs[nextX][nextY]) {
                            costs[nextX][nextY] = curCost + cost;
                            queue.offer(new int[]{nextX, nextY, curCost + cost});
                        }
                    }
                    // 左右移动
                    if (nextY != y) {
                        int cost = colCosts[nextY];
                        if (curCost + cost < costs[nextX][nextY]) {
                            costs[nextX][nextY] = curCost + cost;
                            queue.offer(new int[]{nextX, nextY, curCost + cost});
                        }
                    }
                }
            }
        }
        return costs[homePos[0]][homePos[1]];
    }
}