class MaxVowels {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;

        int res = 0;
        int cur = 0;
        while (r < k) {
            char c = s.charAt(r);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cur ++;
            }
            r++;
        }
        r--;

        res = cur;
        while (r + 1 < n) {
            r++;
            char rc = s.charAt(r);
            if (rc == 'a' || rc == 'e' || rc == 'i' || rc == 'o' || rc == 'u') {
                cur ++;
            }

            char lc = s.charAt(l);
            if (lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u') {
                cur --;
            }
            l++;
            res = Math.max(res, cur);
        }
        return res;
    }
}