class Jump {
    public int jump(int[] nums) {
        int n = nums.length;

        int res = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == end) {
                res++;
                end = max;
            }
        }
        return res;
    }
}