class CountAsterisks {
    public int countAsterisks(String s) {
        int n = s.length();
        int res = 0;
        boolean in = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                in = !in;
            }
            if (s.charAt(i) == '*') {
                res += in ? 0 : 1;
            }
        }
        return res;
    }
}