class OnesMinusZeros {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] diffRow = new int[m];
        for (int i = 0; i < m; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            diffRow[i] = one - zero;
        }
        int[] diffCol = new int[n];
        for (int i = 0; i < n; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            diffCol[i] = one - zero;
        }

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = diffRow[i] + diffCol[j];
            }
        }
        return res;
    }
}