class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        // dp[i]表示前i个数能分隔得到的最大和
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {

            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
            }
        }
        return dp[n];
    }
}