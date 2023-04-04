import java.util.Arrays;

class MaximumCostSubstring {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length();
        int[] map = new int[26];
        Arrays.fill(map, Integer.MIN_VALUE);
        for (int i = 0; i < chars.length(); i++) {
            map[chars.charAt(i) - 'a'] = vals[i];
        }

        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1);
            int v = map[c - 'a'];
            if (v != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i - 1] + v, v);
            } else {
                dp[i] = Math.max(dp[i - 1] + (c - 'a' + 1), (c - 'a') + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}