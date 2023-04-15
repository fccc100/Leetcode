class MaximumScore {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        int[][] dp = new int[m + 1][m + 1];
        int res = Integer.MIN_VALUE;
        for (int k = 1; k <= m; k++) {
            for (int i = 0; i <= k; i++) {
                int j = k - i;
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + nums[n - j] * multipliers[k - 1];
                } else if (i == k) {
                    dp[i][j] = dp[i - 1][j] + nums[k - 1] * multipliers[k - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[k - 1], dp[i][j - 1] + nums[n - j] * multipliers[k - 1]);
                }
                if (k == m) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}