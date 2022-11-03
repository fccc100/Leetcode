class NumMatrix1 {

    int m;
    int n;
    int[][] presum;

    // 二维前缀和
    public NumMatrix1(int[][] matrix) {
        m = matrix.length;
        if (m > 0) {
            n = matrix[0].length;
        }

        presum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
    }
}

//[
// [3, 0, 1, 4, 2],
// [5, 6, 3, 2, 1],
// [1, 2, 0, 1, 5],
// [4, 1, 0, 1, 7],
// [1, 0, 3, 0, 5]
//]

// => 二维前缀和数组f

// f:
//[
// [3,  3,  4,  8, 10],
// [8,  14, 18, 0, 0],
// [9,  17, 21, 0, 0],
// [13, 0,  0,  0, 0],
// [14, 0,  0,  0, 0]
//]

// x1 y1  x2 y2
// f[x2][y2] - f[x2][y1 - 1] - f[x1][y2 - 1] + f[x1 - 1][y1 - 1]