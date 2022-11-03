public class Largest1BorderedSquare2 {
//    public int largest1BorderedSquare(int[][] grid) {
//        int m = grid.length;
//        if (m == 0) return 0;
//        int n = grid[0].length;
//
//        int res = 0;
//
//        int[][] presum = new int[m + 1][n + 1];
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                presum[i][j] = presum[i][j - 1] + presum[i - 1][j] - presum[i - 1][j - 1] + grid[i - 1][j - 1];
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int maxEdge = Math.min(i + 1, j + 1);
//
//                for (int k = 1; k <= maxEdge; k++) {
//
//                    if (check(presum, i, j, k)) {
//                        res = Math.max(res, k * k);
//                    }
//                }
//            }
//        }
//
//        return res;
//    }
//    // presum[row2 + 1][col2 + 1] - presum[row2 + 1][col1] - presum[row1][col2 + 1] + presum[row1][col1];
//    private boolean check(int[][] presum, int x, int y, int k) {
//        // [x - k][y - k] - [x, y]
//        int sum = presum[x + 1][y + 1] - presum[x + 1][y - k] - presum[x - k][y + 1] + presum[x - k][y - k];
//        if (k <= 2) {
//            if (sum == k * k) return true;
//            return false;
//        }
//
//        // [x - k + 1][y - k + 1] - [x - 1, y - 1]
//        int innerSum = presum[x][y] - presum[x][y - k + 1] - presum[x - k + 1][y] + presum[x - k + 1][y - k + 1];
//        if (sum - innerSum == k * 2 + (k - 1) * 2) {
//            return true;
//        }
//        return false;
//    }
}
