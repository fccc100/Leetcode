class CountSubarrays1 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        int l = 0;
        int r = -1;
        long sum = 0;
        long res = 0;
        while (r + 1 < n) {
            r++;
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }

            res += r - l + 1;
        }
        return res;
    }
}
