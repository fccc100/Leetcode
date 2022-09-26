import java.util.ArrayList;

class BallGame {

    int[][] dirs;
    int m;
    int n;
    public int[][] ballGame(int num, String[] plate) {
        m = plate.length;
        if (m == 0) return new int[0][0];
        n = plate[0].length();

        char [][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < plate[i].length(); j++) {
                grid[i][j] = plate[i].charAt(j);
            }
        }

        dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j == n - 1) {
                    continue;
                }
                if (i == m - 1 && j == 0) {
                    continue;
                }
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                if (grid[i][j] != '.') {
                    continue;
                }

                if (i == 0) {
                    if (tryEmit(grid, i, j, 2, 0, num)) {
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(i);
                        cur.add(j);
                        res.add(cur);
                    }
                }
                if (j == 0) {
                    if (tryEmit(grid, i, j, 1, 0, num)) {
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(i);
                        cur.add(j);
                        res.add(cur);
                    }
                }
                if (i == m - 1) {
                    if (tryEmit(grid, i, j, 0, 0, num)) {
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(i);
                        cur.add(j);
                        res.add(cur);
                    }
                }
                if (j == n - 1) {
                    if (tryEmit(grid, i, j, 3, 0, num)) {
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(i);
                        cur.add(j);
                        res.add(cur);
                    }
                }
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        return ans;
    }

    private boolean tryEmit(char[][] grid, int x, int y, int dirIdx, int step, int num) {
        if (step > num) return false;

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        if (grid[x][y] == '.') {
            int[] dir = dirs[dirIdx];
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            return tryEmit(grid, nextX, nextY, dirIdx, step + 1, num);
        } else if (grid[x][y] == 'W') {
            int nextDirIdx = (dirIdx + 4 - 1) % 4;
            int[] dir = dirs[nextDirIdx];
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            return tryEmit(grid, nextX, nextY, nextDirIdx, step + 1, num);
        } else if (grid[x][y] == 'E') {
            int nextDirIdx = (dirIdx + 1) % 4;
            int[] dir = dirs[nextDirIdx];
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            return tryEmit(grid, nextX, nextY, nextDirIdx, step + 1, num);
        } else {
            return true;
        }
    }
}