class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long[] presum = new long[n];
        presum[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            presum[i] = presum[i + 1] + shifts[i];
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long cnt = presum[i];
            cnt %= 26;

            char cur = (char) (((s.charAt(i) - 'a' + cnt) % 26) + Integer.valueOf('a'));
            res.append(cur);
        }
        return res.toString();
    }
}