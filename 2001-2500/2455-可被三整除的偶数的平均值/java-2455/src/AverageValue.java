class AverageValue {
    public int averageValue(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 6 == 0) {
                cnt++;
                sum += nums[i];
            }
        }

        return cnt == 0 ? 0 : sum / cnt;
    }
}