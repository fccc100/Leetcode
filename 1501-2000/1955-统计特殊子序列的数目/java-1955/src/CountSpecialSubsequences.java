class CountSpecialSubsequences {
    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;

        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i ++) {
            if (nums[i - 1] == 0) {
                dp[i][0] = (dp[i - 1][0] * 2 + 1) % mod;
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 1][2];
            } else if (nums[i - 1] == 1) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = (dp[i - 1][0] + (dp[i - 1][1] * 2 % mod)) % mod;
                dp[i][2] = dp[i - 1][2];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = (dp[i - 1][1] + (dp[i - 1][2] * 2 % mod)) % mod;
            }
        }
        return dp[n][2];
    }
}