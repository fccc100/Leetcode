
class WaysToReachTarget {
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int mod = 1000000007;

        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            int[] type = types[i - 1];
            int c = type[0];
            int m = type[1];

            for (int j = 0; j <= c; j++) {
                int score = j * m;

                for (int k = 0; k <= target; k++) {
                    if (score == k) {
                        dp[i][k] = (dp[i][k] + 1) % mod;
                    }
                    if (score < k) {
                        dp[i][k] = (dp[i][k] + dp[i - 1][k - score]) % mod;
                    }
                }
            }
        }
        return dp[n][target] % mod;
    }
}