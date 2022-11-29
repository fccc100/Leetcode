class MinOperations {
    public int minOperations(String s) {
        int n = s.length();
        int res1 = 0;
        int res2 = 0;
        char cur1 = '0';
        char cur2 = '1';
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != cur1) {
                res1++;
            }
            if (s.charAt(i) != cur2) {
                res2++;
            }
            if (cur1 == '0') {
                cur1 = '1';
            } else {
                cur1 = '0';
            }
            if (cur2 == '0') {
                cur2 = '1';
            } else {
                cur2 = '0';
            }
        }
        return Math.min(res1, res2);
    }
}