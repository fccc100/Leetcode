import java.util.HashSet;

class VowelStrings {
    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (set.contains(w.charAt(0)) && set.contains(w.charAt(w.length() - 1))) {
                res ++;
            }
        }
        return res;
    }
}