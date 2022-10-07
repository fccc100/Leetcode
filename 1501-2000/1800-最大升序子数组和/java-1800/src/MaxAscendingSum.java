class MaxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curSum = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] <= nums[j - 1]) {
                    break;
                }
                curSum += nums[j];
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
}