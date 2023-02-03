class MaxProduct {
    int res = 0;
    public int maxProduct(String s) {
        dfs(s, "", "", 0);
        return res;
    }
    private void dfs(String s, String s1, String s2, int index) {
        if (check(s1) && check(s2)) {
            res = Math.max(res, s1.length() * s2.length());
        }
        if (index == s.length()) return;
        dfs(s, s1 + s.charAt(index), s2, index + 1);
        dfs(s, s1, s2 + s.charAt(index), index + 1);
        dfs(s, s1, s2, index + 1);
    }
    private boolean check(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}