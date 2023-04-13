class MostFrequentEven {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[100001];
        int max = -1;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
            if (nums[i] % 2 == 0) {
                max = Math.max(max, cnt[nums[i]]);
            }
        }
        for (int i = 0; i < cnt.length; i += 2) {
            if (cnt[i] == max) return i;
        }
        return -1;
    }
}