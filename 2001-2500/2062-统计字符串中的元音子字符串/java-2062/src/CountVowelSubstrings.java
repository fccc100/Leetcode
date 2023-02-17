import java.util.HashSet;

class CountVowelSubstrings {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!isVowel(c)) continue;
            HashSet<Character> set = new HashSet<>();
            set.add(c);
            for (int j = i + 1; j < n; j++) {
                if (!isVowel(word.charAt(j))) break;
                set.add(word.charAt(j));
                if (set.size() >= 5) {
                    res++;
                }
            }
        }
        return res;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}