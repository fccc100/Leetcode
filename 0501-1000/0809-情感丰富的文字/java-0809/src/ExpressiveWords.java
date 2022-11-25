class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        if (n == 0 || m == 0) return 0;

        int[][] charFreq = toCharFreqArray(s);

        int res = 0;
        for (int i = 0; i < m; i++) {
            int[][] cur = toCharFreqArray(words[i]);
            if (check(charFreq, cur)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(int[][] origin, int[][] other) {
        if (origin.length != other.length) return false;

        boolean res = false;
        for (int i = 0; i < origin.length; i++) {
            if (origin[i][0] != other[i][0]) {
                return false;
            }
            if (origin[i][1] != other[i][1] && origin[i][1] < 3) {
                return false;
            }
            if (origin[i][1] < other[i][1]) {
                return false;
            }
            if (origin[i][1] >= other[i][1] + 2) {
                res = true;
            }
        }
        return res;
    }

    private int[][] toCharFreqArray(String s) {
        int n = s.length();
        int charCnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                charCnt++;
            }
        }

        int[][] res = new int[charCnt][2];
        int idx = 0;
        for (int i = 0; i < n; ) {
            char curChar = s.charAt(i);

            int j = i + 1;
            while (j < n && s.charAt(j) == curChar) {
                j++;
            }

            res[idx] = new int[]{curChar - 'a', j - i};
            idx++;
            i = j;
        }
        return res;
    }
}
