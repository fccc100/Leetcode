class MaximumSumScore {
    public long maximumSumScore(int[] nums) {
        int n = nums.length;

        long[] presum = new long[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }

        long suf = nums[n - 1];
        long res = Math.max(suf, presum[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            suf += nums[i];
            res = Math.max(res, Math.max(presum[i], suf));
        }
        return res;
    }
}