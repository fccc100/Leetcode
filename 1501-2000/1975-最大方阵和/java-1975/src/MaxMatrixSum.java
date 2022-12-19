class MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int negCnt = 0;
        boolean hasZero = false;
        // 因为可以任意交换，所以如果有偶数个负数，最终都可以变为整数
        // 如果有奇数个负数，最终会留下一个负数，选择绝对值最小的一个
        // 如果有0，不管负数个数为偶数还是奇数都可以全部变为正数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    negCnt++;
                }
                if (matrix[i][j] == 0) {
                    hasZero = true;
                }
            }
        }
        if (hasZero) return sum;
        if (negCnt % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}