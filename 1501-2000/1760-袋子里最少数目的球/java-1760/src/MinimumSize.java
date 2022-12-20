class MinimumSize {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        //
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (check(nums, maxOperations, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean check(int[] nums, int maxOperations, int max) {
        int operationCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                operationCnt += (nums[i] - 1) / max;
            }
            if (operationCnt > maxOperations) return false;
        }
        return true;
    }
}