class BalancedString {
    public int balancedString(String s) {
        int n = s.length();
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'Q') cnt[0]++;
            if (c == 'W') cnt[1]++;
            if (c == 'E') cnt[2]++;
            if (c == 'R') cnt[3]++;
        }

        if (cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3]) return 0;
        int avg = (cnt[0] + cnt[1] + cnt[2] + cnt[3]) / 4;
        int l = 0;
        int r = -1;
        int res = n + 1;
        while (l < n) {
            if (max(cnt) > avg) {
                r++;
                if (r >= n) break;
                char c = s.charAt(r);
                if (c == 'Q') cnt[0]--;
                if (c == 'W') cnt[1]--;
                if (c == 'E') cnt[2]--;
                if (c == 'R') cnt[3]--;
            } else {
                res = Math.min(res, r - l + 1);
                char c = s.charAt(l);
                if (c == 'Q') cnt[0]++;
                if (c == 'W') cnt[1]++;
                if (c == 'E') cnt[2]++;
                if (c == 'R') cnt[3]++;
                l++;
            }
        }
        return res;
    }
    private int max(int[] cnt) {
        int max = cnt[0];
        for (int i = 0; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }
}