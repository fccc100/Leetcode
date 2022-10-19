class LongestSubarray1 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = -1;
        int zeroIdx = -1;
        int res = 0;
        while (r + 1 < n) {
            r++;
            if (nums[r] == 0) {
                if (zeroIdx >= 0) {
                    l = zeroIdx + 1;
                }
                zeroIdx = r;
            }

            res = Math.max(res, r - l);
        }
        return res;
    }
}
