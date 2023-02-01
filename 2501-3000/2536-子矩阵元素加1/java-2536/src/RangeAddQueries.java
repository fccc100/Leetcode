class RangeAddQueries {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 2][n + 2];
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            diff[x1 + 1][y1 + 1]++;
            diff[x1 + 1][y2 + 2]--;
            diff[x2 + 2][y1 + 1]--;
            diff[x2 + 2][y2 + 2]++;
        }

        int[][] res = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
                res[i - 1][j - 1] = diff[i][j];
            }
        }
        return res;
    }
}