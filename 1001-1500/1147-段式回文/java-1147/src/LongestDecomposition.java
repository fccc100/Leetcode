class LongestDecomposition {
    public int longestDecomposition(String text) {
        if (text.length() == 0) return 0;
        if (text.length() == 1) return 1;

        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        int l = -1;
        int r = text.length();
        while (l < r) {
            l++;
            head.append(text.charAt(l));
            r--;
            if (l >= r) break;
            tail.insert(0, text.charAt(r));
            if (head.toString().equals(tail.toString())) {
                return 2 + longestDecomposition(text.substring(l + 1, r));
            }
        }
        return 1;
    }
}