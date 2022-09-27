class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int m = s.length();

        n = n % m;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < m; i++) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}