class MinimizedMaximum {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, quantities[i]);
        }

        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + (r - l >> 1);
            // 可以取到mid, mid可能是一个答案，但可能有更小答案
            if (check(quantities, n, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean check(int[] nums, int n, int mid) {
        int cnt = 0;
        for (int i = 0; i <nums.length; i++) {
            int x = nums[i];
            cnt += (x % mid == 0) ? x / mid : x / mid + 1;
        }
        return cnt <= n;
    }
}