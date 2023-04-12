import java.util.Arrays;

class MinCost {
    int[][][] memo;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        memo = new int[m][n + 1][target + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        if (houses[m - 1] != 0) {
            int res = dfs(houses, cost, n, m - 1, houses[m - 1], target);
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dfs(houses, cost, n, m - 1, i + 1, target));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int dfs(int[] houses, int[][] cost, int n, int idx, int colorIdx, int streetCnt) {
        if (idx < 0) return 0;
        if (streetCnt <= 0) return Integer.MAX_VALUE;
        if (idx + 1 < streetCnt) return Integer.MAX_VALUE;

        if (memo[idx][colorIdx][streetCnt] != -1) {
            return memo[idx][colorIdx][streetCnt];
        }

        int curCost = houses[idx] == 0 ? cost[idx][colorIdx - 1] : 0;
        int res = Integer.MAX_VALUE;

        int next = idx - 1;
        if (next < 0) return memo[idx][colorIdx][streetCnt] = curCost;
        if (houses[next] != 0) {
            if (houses[next] == colorIdx) {
                res = Math.min(res, dfs(houses, cost, n, next, houses[next], streetCnt));
            } else {
                res = Math.min(res, dfs(houses, cost, n, next, houses[next], streetCnt - 1));
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i + 1 != colorIdx) {
                    res = Math.min(res, dfs(houses, cost, n, next, i + 1, streetCnt - 1));
                } else {
                    res = Math.min(res, dfs(houses, cost, n, next, i + 1, streetCnt));
                }
            }
        }

        return memo[idx][colorIdx][streetCnt] = res == Integer.MAX_VALUE ? Integer.MAX_VALUE : curCost + res;
    }
}