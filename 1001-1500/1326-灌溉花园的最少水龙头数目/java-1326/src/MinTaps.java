import java.util.Arrays;

class MinTaps {
    public int minTaps(int n, int[] ranges) {
        int m = ranges.length;
        int[][] intervals = new int[m][2];
        for (int i = 0; i < m; i++) {
            int k = ranges[i];
            int l = Math.max(0, i - k);
            int r = Math.min(i + k, m - 1);
            intervals[i] = new int[]{l, r};
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // dp[i]表示覆盖i位置可选的最少区间数目
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (dp[start] == Integer.MAX_VALUE) return -1;

            for (int j = start; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }
        return dp[m - 1];
    }
}