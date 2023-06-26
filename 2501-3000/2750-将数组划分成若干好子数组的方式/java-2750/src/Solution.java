class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long mod = 1000000007;

        int n = nums.length;
        boolean prevOne = false;
        long res = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!prevOne) {
                if (nums[i] == 0) continue;
                if (nums[i] == 1) {
                    prevOne = true;
                    continue;
                }
            } else {
                if (nums[i] == 0) {
                    cnt++;
                } else {
                    res = (res * (cnt + 1)) % mod;
                    cnt = 0;
                }
            }
        }
        return prevOne ? (int) res : 0;
    }
}