class MissingNumber1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = (n + 1) * (0 + n) / 2;

        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
        }
        return sum - curSum;
    }
}