class MinKBitFlips {
    // TLE
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i + k > n) {
                    return -1;
                }
                for (int j = i; j < i + k; j++) {
                    nums[j] ^= 1;
                }
                res++;
            }
        }
        return res;
    }
}