class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int n = s.length();

        int lCnt = 0;
        int rCnt = 0;
        for (int i = 0; i < n; i++) {
            if (check(s.charAt(i))) {
                if (i < n / 2) {
                    lCnt++;
                } else {
                    rCnt++;
                }
            }
        }
        return lCnt == rCnt;
    }

    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}