class MaximumCandies {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }

        long max = sum / k;
        long l = 0;
        long r = max;

        while (l < r) {
            long mid = l + (r - l + 1 >> 1);

            if (check(candies, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    private boolean check(int[] nums, long c, long k) {
        int n = nums.length;

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i] / c;
        }
        return res >= k;
    }
}