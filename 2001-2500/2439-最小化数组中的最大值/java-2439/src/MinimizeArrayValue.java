class MinimizeArrayValue {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int l = 0, r = max;
        while (l < r) {
            int mid = l + (r - l >> 1);

            if (check(nums, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int k) {
        int n = nums.length;

        long capacity = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= k) {
                capacity += k - nums[i];
            } else {
                if (capacity < nums[i] - k) {
                    return false;
                } else {
                    capacity -= nums[i] - k;
                }
            }
        }
        return true;
    }
}

