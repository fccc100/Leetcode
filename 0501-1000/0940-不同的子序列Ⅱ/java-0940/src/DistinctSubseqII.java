class DistinctSubseqII {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int mod = 1000000007;

        // dp[i][j]表示s前i个字符以j结尾的子序列个数
        int[][] dp = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (c != j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int cur = 1;
                    for (int k = 0; k < 26; k++) {
                        cur = (cur + dp[i - 1][k]) % mod;
                    }
                    dp[i][j] = cur;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = (res + dp[n][i]) % mod;
        }
        return res;
    }
}