import java.util.Arrays;

class LongestPalindrome {
    public int longestPalindrome(String word1, String word2) {
        int m1 = word1.length();
        int m2 = word2.length();
        String s = word1 + word2;
        int n = s.length();

        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                    if (i < m1 && j >= m1) res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return res;
    }
}