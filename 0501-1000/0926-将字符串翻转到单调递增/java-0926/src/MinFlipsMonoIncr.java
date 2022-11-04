class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        int[] leftOneCnt = new int[n];
        for (int i = 1; i < n; i++) {
            leftOneCnt[i] = s.charAt(i - 1) == '1' ? leftOneCnt[i - 1] + 1 : leftOneCnt[i - 1];
        }

        int[] rightZeroCnt = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightZeroCnt[i] = s.charAt(i + 1) == '0' ? rightZeroCnt[i + 1] + 1 : rightZeroCnt[i + 1];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(leftOneCnt[i] + rightZeroCnt[i], res);
        }
        return res;
    }
}