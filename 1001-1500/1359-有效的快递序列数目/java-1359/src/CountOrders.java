class CountOrders {
    public int countOrders(int n) {
        long[] dp = new long[n+1];
        int mod = 1000000007;
        dp[1] = 1L;
        for (int i = 2; i <= n; ++i) {
            dp[i] = i * (2 * i - 1) * dp[i - 1] % mod;
        }

        return (int) dp[n];
    }
}