class LongestSubsequence {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                res++;
            }
        }

        long val = 0;
        long cur = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                val += cur;
                if (val <= k) {
                    res++;
                }
            }
            if (cur > k) break;

            cur *= 2;
        }

        return res;
    }
}