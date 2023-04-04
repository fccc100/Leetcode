class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        long minAvg = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            long lSum = presum[i + 1];
            long rSum = presum[n] - presum[i + 1];
            long curAvg = Math.abs(lSum / (i + 1) - ((n - i - 1) == 0 ? 0 : rSum / (n - i - 1)));
            if (curAvg < minAvg) {
                minAvg = curAvg;
                res = i;
            }
        }
        return res;
    }
}