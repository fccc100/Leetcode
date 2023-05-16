class MaximumOr {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;

        int[] suffix = new int[n + 1];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] | nums[i];
        }

        long res = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, pre | ((long) nums[i] << k) | suffix[i + 1]);
            pre = pre | nums[i];
        }
        return res;
    }
}
