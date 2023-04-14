class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = 0;
        for (int x : stones) sum += x;

        int c = sum / 2;
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i <= n; i++) {
            int w = stones[i - 1];
            for (int j = 1; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w] + w);
                }
            }
        }
        return sum - 2 * dp[n][c];
    }
}