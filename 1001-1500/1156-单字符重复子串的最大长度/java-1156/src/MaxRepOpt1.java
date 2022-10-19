class MaxRepOpt1 {
    public int maxRepOpt1(String text) {
        int n = text.length();

        int[] charCnt = new int[26];
        for (int i = 0; i < n; i++) {
            charCnt[text.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < n;) {
            char cur = text.charAt(i);
            int diffIdx = -1;
            int curCnt = 1;

            int j = i + 1;
            while (j < n && (text.charAt(j) == cur || diffIdx < 0)) {
                if (text.charAt(j) != cur) {
                    diffIdx = j;
                } else {
                    curCnt++;
                }
                j++;
            }

            if (curCnt == charCnt[cur - 'a']) {
                if (diffIdx < 0) {
                    res = Math.max(res, j - i);
                } else {
                    res = Math.max(res, j - i - 1);
                }
            } else {
                if (diffIdx < 0) {
                    res = Math.max(res, j - i + 1);
                } else {
                    res = Math.max(res, j - i);
                }
            }
            if (diffIdx < 0) {
                break;
            }
            i = diffIdx;
        }
        return res;
    }
}