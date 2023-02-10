class MinCapability {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int l = min, r = max;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (check(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean check(int[] nums, int mid, int k) {
        int n = nums.length;
        int cnt = 0;
        int prev = -2;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                if (i - prev > 1) {
                    cnt++;
                    prev = i;
                }
            }
        }
        return cnt >= k;
    }
}