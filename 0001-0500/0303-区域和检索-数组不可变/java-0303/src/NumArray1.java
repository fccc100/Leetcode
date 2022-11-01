class NumArray1 {

    int[] presum;
    public NumArray1(int[] nums) {
        int n = nums.length;
        presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return presum[right + 1] - presum[left];
    }
}