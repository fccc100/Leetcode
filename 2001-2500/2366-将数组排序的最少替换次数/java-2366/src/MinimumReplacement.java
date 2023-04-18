class MinimumReplacement {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;

        int next = nums[n - 1];
        long res = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > next) {
                int cnt = (int) Math.ceil((double) nums[i] / next);
                res += cnt - 1;
                next = nums[i] / cnt;
            } else {
                next = nums[i];
            }
        }
        return res;
    }
}