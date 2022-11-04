class MaxSideLength {
    // 二维前缀和
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        if (m == 0) return 0;
        int n = mat[0].length;

        int[][] presum = new int[m][n];
        presum[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) {
            presum[i][0] = presum[i - 1][0] + mat[i][0];
        }

        for (int i = 1; i < n; i++) {
            presum[0][i] = presum[0][i - 1] + mat[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + mat[i][j];
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // [i, j]点为左上角点

                int e = Math.min(m - i, n - j);
                for (int k = 1; k <= e; k++) {
                    // [i + k - 1, j + k - 1]为右下角点

                    int sum = check(presum, i, j, k);
                    if (sum <= threshold) {

                        res = Math.max(res, k);
                    } else break;
                }
            }
        }
        return res;
    }

    private int check(int[][] presum, int x, int y, int k) {
        int sum = presum[x + k - 1][y + k - 1] - (y - 1 >= 0 ? presum[x + k - 1][y - 1] : 0) - (x - 1 >= 0 ? presum[x - 1][y + k - 1] : 0) + (x - 1 >= 0 && y - 1 >= 0 ? presum[x - 1][y - 1] : 0);
        return sum;
    }
}
