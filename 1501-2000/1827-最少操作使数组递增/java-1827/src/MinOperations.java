class MinOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff <= 0) {
                nums[i] = nums[i - 1] + 1;
                res += Math.abs(diff) + 1;
            }
        }
        return res;
    }
}