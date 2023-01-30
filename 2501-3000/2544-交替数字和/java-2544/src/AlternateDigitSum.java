class AlternateDigitSum {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int res = 0;
        boolean add = true;
        for (int i = 0; i < s.length(); i++) {
            if (add) {
                res += s.charAt(i) - '0';
            } else {
                res -= s.charAt(i) - '0';
            }
            add = !add;
        }
        return res;
    }
}