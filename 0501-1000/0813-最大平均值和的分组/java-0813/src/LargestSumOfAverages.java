class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        double[][] dp = new double[n][k + 1];
        double[] presum = new double[n];
        presum[0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
            dp[i][1] = presum[i] / (i + 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= k; j++) {

                for (int t = i - 1; t >= 0; t--) {
                    dp[i][j] = Math.max(dp[i][j], dp[t][j - 1] + (presum[i] - presum[t]) / (i - t));
                }
            }
        }
        return dp[n - 1][k];
    }
}
