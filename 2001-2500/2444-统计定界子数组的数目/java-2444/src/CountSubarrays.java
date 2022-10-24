class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        int minIdx = -1;
        int maxIdx = -1;
        int t = -1;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == minK) {
                minIdx = i;
            }
            if (x == maxK) {
                maxIdx = i;
            }
            if (x < minK || x > maxK) {
                t = i;
            }

            res += Math.max(Math.min(minIdx, maxIdx) - t, 0);
        }
        return res;
    }
}