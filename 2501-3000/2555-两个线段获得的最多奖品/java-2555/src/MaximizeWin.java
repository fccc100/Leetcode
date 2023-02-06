class MaximizeWin {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;

        int[] rightMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = i + 1 >= n ? 0 : rightMax[i + 1];
            // 大于x + k的最小值
            int r = upper(prizePositions, prizePositions[i] + k);
            rightMax[i] = Math.max(rightMax[i], r - i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int r = upper(prizePositions, prizePositions[i] + k);
            int rr = r >= n ? 0 : rightMax[r];
            res = Math.max(res, r - i + rr);
        }
        return res;
    }
    // 大于target的最小值
    private int upper(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

// [1,1,2,2,3,3,5] 2
// [6,6,6,6,7,7,7]
// [6,5,4,3,3,2,1]