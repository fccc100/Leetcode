class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;

        int[][] res = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;

                int x = idx / c;
                int y = idx % c;
                res[x][y] = mat[i][j];
            }
        }
        return res;
    }
}