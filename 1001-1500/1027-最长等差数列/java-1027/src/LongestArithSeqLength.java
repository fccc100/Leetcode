class LongestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        // dp[i][j]:前i项以j为公差的最长等差子序列
        int[][] dp = new int[n][1001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int d = x - nums[j];
                dp[i][d + 500] = Math.max(dp[i][d + 500], dp[j][d + 500] + 1);
                res = Math.max(res, dp[i][d + 500]);
            }
        }
        return res;
    }
}