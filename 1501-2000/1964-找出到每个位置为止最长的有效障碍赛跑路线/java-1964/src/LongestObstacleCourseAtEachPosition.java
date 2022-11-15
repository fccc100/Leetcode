import java.util.Arrays;

class LongestObstacleCourseAtEachPosition {

    // TLE
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        // 以i结尾最长递增子序列
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (obstacles[i] >= obstacles[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
}
