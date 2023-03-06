class CountTriplets {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[1 << 16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[nums[i] & nums[j]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < (1 << 16); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & nums[j]) == 0) {
                    res += cnt[i];
                }
            }
        }
        return res;
    }
}