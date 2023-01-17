class DifferenceOfSum {
    public int differenceOfSum(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            sum1 += x;
            while (x > 0) {
                sum2 += x % 10;
                x /= 10;
            }
        }
        return Math.abs(sum1 - sum2);
    }
}