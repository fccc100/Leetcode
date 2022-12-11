class CountCollisions {
    public int countCollisions(String directions) {
        int n = directions.length();

        int res = 0;
        int rCnt = 0;
        int sCnt = 0;
        for (int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if (c == 'L') {
                if (rCnt > 0) {
                    res += 2;
                    rCnt--;
                    res += rCnt;
                    rCnt = 0;
                    sCnt++;
                } else if (sCnt > 0) {
                    res += 1;
                }
            } else if (c == 'R') {
                rCnt++;
            } else {
                if (rCnt > 0) {
                    res += rCnt;
                    rCnt = 0;
                }
                sCnt++;
            }
        }
        return res;
    }
}
