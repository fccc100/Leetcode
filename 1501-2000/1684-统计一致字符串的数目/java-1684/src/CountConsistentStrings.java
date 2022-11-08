import java.util.HashSet;

class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int n = words.length;

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            String word = words[i];

            boolean isMatch = true;
            for (int j = 0; j < word.length(); j++) {
                if (!set.contains(word.charAt(j))) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) res++;
        }
        return res;
    }
}