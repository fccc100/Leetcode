import java.util.Arrays;

class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
        int n = p.length();

        int[] dp = new int[26];
        dp[p.charAt(0) - 'a'] = 1;

        int curLen = 1;
        for (int i = 1; i < n; i++) {
            if ((p.charAt(i) == 'a' && p.charAt(i - 1) == 'z') || p.charAt(i) - p.charAt(i - 1) == 1) {
                curLen++;
            } else {
                curLen = 1;
            }

            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], curLen);
        }

        return Arrays.stream(dp).sum();
    }
}
