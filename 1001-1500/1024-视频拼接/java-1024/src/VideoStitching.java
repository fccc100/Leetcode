class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);

        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] interval : clips) {
            int start = Math.min(interval[0], time);
            int end = Math.min(time, interval[1]);

            if (dp[start] == Integer.MAX_VALUE) return -1;

            for (int j = start; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }
        return dp[time] == Integer.MAX_VALUE ? -1 : dp[time];
    }
}