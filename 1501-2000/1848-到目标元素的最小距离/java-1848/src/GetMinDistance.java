class GetMinDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}