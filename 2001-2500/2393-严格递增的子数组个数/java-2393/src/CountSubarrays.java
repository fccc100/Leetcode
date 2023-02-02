class CountSubarrays {
    public long countSubarrays(int[] nums) {
        int n = nums.length;
        long res = 1;
        long cur = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cur ++;
            } else {
                cur = 1;
            }
            res += cur;
        }
        return res;
    }
}