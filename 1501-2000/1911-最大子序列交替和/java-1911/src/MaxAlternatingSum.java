class MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] dpOdd = new long[n];
        long[] dpEven = new long[n];
        dpOdd[0] = 0;
        dpEven[0] = nums[0];
        long res = Math.max(dpOdd[0], dpEven[0]);
        for (int i = 1; i < n; i++) {
            dpOdd[i] = Math.max(dpEven[i - 1] - nums[i], dpOdd[i - 1]);
            dpEven[i] = Math.max(dpOdd[i - 1] + nums[i], dpEven[i - 1]);
            res = Math.max(res, dpOdd[i]);
            res = Math.max(res, dpEven[i]);
        }
        return res;
    }
}
//         0  1  2  3
//        [4, 2, 5, 3]
// dpOdd  [0, 2, -3, 4]
// dpEv   [4, 2, 7,  0]