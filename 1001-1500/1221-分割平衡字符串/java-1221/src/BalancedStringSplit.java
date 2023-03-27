class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int lCnt = 0;
        int rCnt = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                lCnt++;
            } else {
                rCnt++;
            }
            if (lCnt == rCnt) {
                res++;
                lCnt = 0;
                rCnt = 0;
            }
        }
        return res;
    }
}