class NumberOfArrays {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int MOD = 1000000007;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long cur = 0;
            long d = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > 10) break;
                if (s.charAt(j) != '0') {
                    cur = (s.charAt(j) - '0') * d + cur;
                    if (cur > k) break;
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
                d *= 10;
            }
        }
        return (int) dp[n];
    }
}