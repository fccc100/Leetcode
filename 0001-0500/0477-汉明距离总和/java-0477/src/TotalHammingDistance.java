class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;

        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int c = 0;

            for (int j = 0; j < n; j++) {
                c += (1 & (nums[j] >> i));
            }

            res += c * (n - c);
        }
        return res;
    }
}