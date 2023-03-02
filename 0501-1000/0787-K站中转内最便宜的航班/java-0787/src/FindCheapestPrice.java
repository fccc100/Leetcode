import java.util.Arrays;

class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // dp[i][j]表示到达i点经过j条边的最小花费
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int j = 0; j < flights.length; j++) {
                int v1 = flights[j][0];
                int v2 = flights[j][1];
                int w = flights[j][2];
                if (dp[i - 1][v1] != Integer.MAX_VALUE && dp[i - 1][v1] + w < dp[i][v2]) {
                    dp[i][v2] = dp[i - 1][v1] + w;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            res = Math.min(res, dp[i][dst]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}