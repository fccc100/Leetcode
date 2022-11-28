class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        // dp[i][j]表示前i个元素分割成j份能得到的最大得分
        double[][] dp = new double[n][k + 1];
        double[] presum = new double[n];
        presum[0] = nums[0];
        dp[0][1] = nums[0];

        // 求前缀和及前i个元素分割成1份的得分
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
            dp[i][1] = presum[i] / (i + 1);
        }

        // i位置分割成j份的最大得分，就等于[0, i)区间内选择某个点t，t位置分割成j - 1份加上[t, i)区间的平均数 的最大值
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
