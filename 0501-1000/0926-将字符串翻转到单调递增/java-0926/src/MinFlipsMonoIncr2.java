public class MinFlipsMonoIncr2 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        // dp[i][0] 表示i位置为0的最小翻转次数
        // dp[i][1] 表示i位置为1的最小翻转次数
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '1' ? 1 : 0;
        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '1' ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
