class WaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        long presum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            presum += nums[i];
            if (i < n - 1 && presum >= sum - presum) {
                res++;
            }
        }
        return res;
    }
}