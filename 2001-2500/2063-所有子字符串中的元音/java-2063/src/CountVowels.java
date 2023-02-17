class CountVowels {
    public long countVowels(String word) {
        int n = word.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (isVowel(c)) {
                res += (long) (i + 1) * (n - i);
            }
        }
        return res;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}