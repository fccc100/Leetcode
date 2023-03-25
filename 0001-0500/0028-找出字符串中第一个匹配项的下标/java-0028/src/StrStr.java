class StrStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) return -1;

        for (int i = 0; i + n - 1 < m; i++) {
            int j ;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) return i;
        }
        return -1;
    }
}