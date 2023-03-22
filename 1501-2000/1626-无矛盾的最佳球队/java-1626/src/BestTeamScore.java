import java.util.Arrays;

class BestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = ages[i];
            pairs[i][1] = scores[i];
        }
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return a[1] - b[1];
            }
        });

        int[] dp = new int[n];
        dp[0] = pairs[0][1];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = pairs[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] == pairs[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + pairs[i][1]);
                } else if (pairs[j][1] <= pairs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + pairs[i][1]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// scores = [4,5,6,5], ages = [2,1,2,1]
// [1,5][1,5][2,4][2,6]
// 5      10   4   16

// scores = [1,2,3,5], ages = [8,9,10,1]
// [1,5][8,1][9,2][10,3]