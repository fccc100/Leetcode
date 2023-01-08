class MinOperations {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        long t = sum - x;
        int l = 0;
        int r = -1;
        long cur = 0;
        // 找到最长的cur == t的区间
        int max = -1;
        while (l < n && r < n) {
            if (cur < t) {
                r++;
                if (r >= n) break;
                cur += nums[r];
            } else if (cur > t) {
                cur -= nums[l];
                l++;
            } else {
                max = Math.max(max, r - l + 1);
                cur -= nums[l];
                l++;
                r++;
                if (r >= n) break;
                cur += nums[r];
            }
        }
        return max == -1 ? -1 : n - max;
    }
}