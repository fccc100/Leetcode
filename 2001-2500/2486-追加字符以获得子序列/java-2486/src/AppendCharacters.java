class AppendCharacters {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return n - j;
    }
}