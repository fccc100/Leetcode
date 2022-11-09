import java.util.Arrays;

class OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n == 0) return 0;
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nums[i], 1);
        }
        for (int i = 0; i < mines.length; i++) {
            nums[mines[i][0]][mines[i][1]] = 0;
        }

        // 动态规划
        // dp[i][j][0]表示[i, j]点向上的最大长度
        // dp[i][j][1]表示[i, j]点向右的最大长度
        // dp[i][j][2]表示[i, j]点向下的最大长度
        // dp[i][j][3]表示[i, j]点向左的最大长度
        int[][][] dp = new int[n][n][4];
        int res = 0;
        dp[0][0][0] = nums[0][0];
        dp[0][0][3] = nums[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0][3] = nums[i][0];
            if (nums[i][0] == 0) {
                dp[i][0][0] = 0;
            } else {
                dp[i][0][0] = dp[i - 1][0][0] + 1;
            }

            dp[0][i][0] = nums[0][i];
            if (nums[0][i] == 0) {
                dp[0][i][3] = 0;
            } else {
                dp[0][i][3] = dp[0][i - 1][3] + 1;
            }
        }

        if (mines.length < n * n) {
            res = 1;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (nums[i][j] == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][3] = 0;
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][3] = dp[i][j - 1][3] + 1;
                }
            }
        }

        dp[n - 1][n - 1][1] = nums[n - 1][n - 1];
        dp[n - 1][n - 1][2] = nums[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][n - 1][1] = nums[i][n - 1];
            if (nums[i][n - 1] == 0) {
                dp[i][n - 1][2] = 0;
            } else {
                dp[i][n - 1][2] = dp[i + 1][n - 1][2] + 1;
            }

            dp[n - 1][i][2] = nums[n - 1][i];
            if (nums[n - 1][i] == 0) {
                dp[n - 1][i][1] = 0;
            } else {
                dp[n - 1][i][1] = dp[n - 1][i + 1][1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (nums[i][j] == 0) {
                    dp[i][j][1] = 0;
                    dp[i][j][2] = 0;
                } else {
                    dp[i][j][1] = dp[i][j + 1][1] + 1;
                    dp[i][j][2] = dp[i + 1][j][2] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, min4(dp[i][j][0], dp[i][j][1], dp[i][j][2], dp[i][j][3]));
            }
        }
        return res;
    }

    private int min4(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
