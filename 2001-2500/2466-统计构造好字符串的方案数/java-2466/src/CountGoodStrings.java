class CountGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = 1000000007;

        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }

            dp[i] %= mod;
        }

        int res = 0;
        for (int i = low; i <= high; i++) {
            res = (res + dp[i]) % mod;
        }
        return res;
    }
}