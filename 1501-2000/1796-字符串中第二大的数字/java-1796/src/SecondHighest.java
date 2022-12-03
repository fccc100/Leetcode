class SecondHighest {
    public int secondHighest(String s) {
        int n = s.length();

        int f = -1;
        int se = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (d > f) {
                    se = f;
                    f = d;
                } else if (d < f && d > se) {
                    se = d;
                }
            }
        }
        return se;
    }
}