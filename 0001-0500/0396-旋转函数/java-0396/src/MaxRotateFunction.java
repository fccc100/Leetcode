class MaxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[0] += i * nums[i];
        }

        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] - ((n - 1) * nums[n - i]) + sum - nums[n - i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
