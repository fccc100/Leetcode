class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        int[][] row = new int[10][10];
        int[][] col = new int[10][10];
        int[][] bucket = new int[10][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (row[i][board[i][j] - '0'] == 1) {
                    return false;
                }
                if (col[j][board[i][j] - '0'] == 1) {
                    return false;
                }
                int bucketIdx = (i / 3) * 3 + j / 3;
                if (bucket[bucketIdx][board[i][j] - '0'] == 1) {
                    return false;
                }
                row[i][board[i][j] - '0'] = 1;
                col[j][board[i][j] - '0'] = 1;
                bucket[bucketIdx][board[i][j] - '0'] = 1;
            }
        }
        return true;
    }
}