class FindSquare {
    public int[] findSquare(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[]{};
        int max = -1;
        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) continue;

                int m = Math.min(n - i, n - j);
                if (m <= max) continue;
                for (int k = m; k > Math.max(max, 0); k--) {
                    if (check(matrix, i, j, k)) {
                        max = k;
                        res[0] = i;
                        res[1] = j;
                        res[2] = k;
                    }
                }
            }
        }
        return max > -1 ? res : new int[]{};
    }
    private boolean check(int[][] matrix, int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (i == x && matrix[i][j] != 0) return false;
                if (j == y && matrix[i][j] != 0) return false;
                if (i == x + len - 1 && matrix[i][j] != 0) return false;
                if (j == y + len - 1 && matrix[i][j] != 0) return false;
            }
        }
        return true;
    }
}
