class IsOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (s.equals(t)) return false;

        if (Math.abs(m - n) > 1) return false;

        if (m == n) {
            int diff = 0;
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff++;
                }
                if (diff > 1) return false;
            }
            return true;
        } else if (m - n == 1) {
            int diff = 0;
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (s.charAt(i) != t.charAt(j)) {
                    diff++;
                    i++;
                } else {
                    i++;
                    j++;
                }
                if (diff > 1) return false;
            }
            return true;
        } else {
            int diff = 0;
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (s.charAt(i) != t.charAt(j)) {
                    diff++;
                    j++;
                } else {
                    i++;
                    j++;
                }
                if (diff > 1) return false;
            }
            return true;
        }
    }
}