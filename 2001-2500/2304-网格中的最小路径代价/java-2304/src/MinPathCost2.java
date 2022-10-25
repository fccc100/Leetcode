import java.util.Arrays;

public class MinPathCost2 {

    // 动态规划 记忆化搜索
    int m;
    int n;
    int[][] memo;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;

        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dfs(grid, 0, i, moveCost));
        }
        return res;
    }
    private int dfs(int[][] grid, int x, int y, int[][] moveCost) {
        if (x == m - 1) return grid[x][y];

        if (memo[x][y] > -1) {
            return memo[x][y];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, grid[x][y] + moveCost[grid[x][y]][i] + dfs(grid, x + 1, i, moveCost));
        }
        return memo[x][y] = res;
    }
}
