class MinInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        String t = sb.toString();

        int lcs = lcs(s, t);
        return n - lcs;
    }

    private int lcs(String s1, String s2) {
        int n = s1.length();

        // dp[i][j]表示s1[0, i]范围与s2[0, j]范围的lcs
        int[][] dp = new int[n + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}