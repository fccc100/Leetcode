class GetMaxMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[]{};
        int n = matrix[0].length;

        int[][] presum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                presum[i][j] = presum[i - 1][j] + matrix[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {

                int[] curNums = new int[n];
                for (int k = 0; k < n; k++) {
                    curNums[k] = presum[j + 1][k + 1] - presum[i][k + 1];
                }

                int[] max = maxSubarraySum(curNums);
                if (max[0] > maxSum) {
                    maxSum = max[0];
                    x1 = i;
                    y1 = max[1];
                    x2 = j;
                    y2 = max[2];
                }
            }
        }

        return new int[]{x1, y1, x2, y2};
    }
    private int[] maxSubarraySum(int[] nums) {
        int n = nums.length;

        int start = 0;
        int max = nums[0];
        int presum = nums[0];
        int[] res = new int[3];

        for (int i = 1; i < n; i++) {
            if (presum > 0) {
                presum += nums[i];
            } else {
                presum = nums[i];
                start = i;
            }
            if (presum > max) {
                max = presum;
                res[1] = start;
                res[2] = i;
            }
        }
        res[0] = max;
        return res;
    }
}
