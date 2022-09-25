class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int res = 0;
        int curLen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                curLen++;
            } else {
                curLen = 0;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}