
// TLE
class StreamChecker {
    String[] words;
    StringBuilder s;
    public StreamChecker(String[] words) {
        this.words = words;
        s = new StringBuilder();
    }

    public boolean query(char letter) {
        s.append(letter);
        for (String w : words) {
            if (s.indexOf(w) > -1 && s.indexOf(w) + w.length() == s.length()) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */