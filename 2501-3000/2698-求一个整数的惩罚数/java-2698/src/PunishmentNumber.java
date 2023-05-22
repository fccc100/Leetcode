class PunishmentNumber {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i * i);

            if (check(s, i)) {
                res += i * i;
            }
        }

        return res;
    }
    private boolean check(String s, int t) {
        if (Integer.valueOf(s) == t) {
            return true;
        }

        return f(s, 0, t, 0);
    }
    private boolean f(String s, int c, int t, int idx) {
        if (idx >= s.length() && c == t) {
            return true;
        }
        if (c > t) return false;
        if (idx > s.length()) return false;

        boolean res = false;
        for (int i = idx; i < s.length(); i++) {
            String m = s.substring(idx, i + 1);
            if (Integer.valueOf(m) <= t) {
                res = res || f(s, c + Integer.valueOf(m), t, i + 1);
            }
        }
        return res;
    }
}