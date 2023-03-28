class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String revs = sb.reverse().toString();

        for (int i = n; i >= 1; i--) {
            if (s.substring(0, i).equals(revs.substring(n - i, n))) {
                return revs.substring(0, n - i) + s;
            }
        }
        return "";
    }
}