import java.util.HashMap;
import java.util.HashSet;

class EqualFrequency {
    public boolean equalFrequency(String word) {
        int n = word.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);
            }
            set.clear();
            for (Integer e : map.values()) {
                set.add(e);
            }
            if (set.size() == 1) {
                return true;
            }
        }
        return false;
    }
}