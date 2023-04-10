class MaxTotalFruits {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int max = Math.max(fruits[n - 1][0], startPos);
        int[] nums = new int[max + 1];
        for (int i = 0; i < n; i++) {
            nums[fruits[i][0]] += fruits[i][1];
        }
        int[] presum = new int[max + 2];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int i = 0; i <= startPos; i++) {
            int leftDis = startPos - i;
            if (leftDis > k) continue;

            int left = k - (2 * leftDis);
            int maxRight = Math.min(max, startPos + left);
            res = Math.max(res, presum[maxRight + 1] - presum[i]);

            int maxRight2 = Math.min(max, startPos +(k - leftDis) / 2);
            res = Math.max(res, presum[maxRight2 + 1] - presum[i]);
        }
        return res;
    }
}