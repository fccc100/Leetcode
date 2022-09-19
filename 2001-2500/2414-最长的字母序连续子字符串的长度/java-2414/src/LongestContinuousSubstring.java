class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return 1;

        int curCode = s.charAt(0) - 'a';
        int curLen = 1;

        int res = 1;
        for (int i = 1; i < n; i++) {
            int code = s.charAt(i) - 'a';
            if (code == curCode + 1) {
                curLen++;
                curCode = code;
            } else {
                curCode = code;
                curLen = 1;
            }

            res = Math.max(res, curLen);
        }
        return res;
    }
}