class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;

        int[][] res = new int[m - 2][m - 2];

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int max = grid[i][j];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}