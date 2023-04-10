class FindTheLongestBalancedSubstring {
    public int findTheLongestBalancedSubstring(String s) {
        char[] c = s.toCharArray();
        int pre = 0, cur = 0, n = c.length, res = 0;
        for (int i = 0; i < n; i++) {
            cur++;
            if (i == n - 1 || c[i] != c[i + 1]) {
                if (c[i] == '1') {
                    res = Math.max(res, Math.min(cur, pre) * 2);
                }
                pre = cur;
                cur = 0;
            }
        }
        return res;
    }
}