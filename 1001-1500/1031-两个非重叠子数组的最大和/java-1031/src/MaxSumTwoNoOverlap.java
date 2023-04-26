class MaxSumTwoNoOverlap {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        int max = 0;
        for (int i = 0; i <= n - firstLen; i++) {
            // [i, i + firstLen - 1]
            int firstSum = presum[i + firstLen] - presum[i];

            // [j, j + secondLen - 1]
            int secondSum = 0;
            for (int j = i - secondLen; j >= 0; j--) {
                secondSum = presum[j + secondLen] - presum[j];
                max = Math.max(max, firstSum + secondSum);
            }
            for (int j = i + firstLen; j <= n - secondLen; j++) {
                secondSum = presum[j + secondLen] - presum[j];
                max = Math.max(max, firstSum + secondSum);
            }
        }
        return max;
    }
}