class MinPatches {
    public int minPatches(int[] nums, int n) {

        int res = 0;
        int i = 0;
        for (long t = 1; t <= n; ) {
            if (i < nums.length && nums[i] <= t) {
                t += nums[i];
                i++;
            } else {
                res++;
                t *= 2;
            }
        }

        return res;
    }
}
