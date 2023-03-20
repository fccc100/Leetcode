class MaximumProfit {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = future[i] - present[i];
        }

        // dp[i][j]: 前i个物品填满j容量背包的最大价值
        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 1; i <= n; i++) {
            int w = present[i - 1];
            int v = vals[i - 1];
            for (int j = 0; j <= budget; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (w <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w] + v);
                }
            }
        }
        return dp[n][budget];
    }
}
