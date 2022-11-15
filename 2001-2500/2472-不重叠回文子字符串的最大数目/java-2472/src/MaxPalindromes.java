import java.util.Arrays;

class MaxPalindromes {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        boolean[][] dp = longestPalindrome(s);
        int[] minRight = new int[n];
        Arrays.fill(minRight, -1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[i][j]) {
                    if (j - i + 1 >= k) {
                        minRight[i] = j;
                        break;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            int nextStart = n;
            for (int j = n - 1; j >= i; j--) {
                if (minRight[j] >= 0 && minRight[j] < nextStart) {
                    cur++;
                    nextStart = j;
                }
            }

            res = Math.max(res, cur);
        }
        return res;
    }

    public boolean[][] longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp;
    }
}