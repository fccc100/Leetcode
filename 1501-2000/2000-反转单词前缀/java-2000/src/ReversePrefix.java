class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                idx = i;
                break;
            }
        }

        if (idx == -1) return word;

        StringBuilder res = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            res.append(word.charAt(i));
        }
        for (int i = idx + 1; i < word.length(); i++) {
            res.append(word.charAt(i));
        }
        return res.toString();
    }
}