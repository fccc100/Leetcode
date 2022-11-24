class NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int prev1 = -1;
        int prev2 = -1;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                prev2 = i;
                prev1 = -1;
            } else if (nums[i] >= left) {
                prev1 = i;
            }
            if (prev1 != -1) {
                res += prev1 - prev2;
            }
        }

        return res;
    }
}

