import java.util.HashMap;
import java.util.HashSet;

class MatchReplacement {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int m = s.length();
        int n = sub.length();

        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (int i = 0; i < mappings.length; i++) {
            if (!map.containsKey(mappings[i][0])) {
                map.put(mappings[i][0], new HashSet<>());
            }
            map.get(mappings[i][0]).add(mappings[i][1]);
        }

        for (int i = 0; i < m; i++) {
            boolean matched = true;
            if (i + n > m) break;
            for (int j = i; j < i + n; j++) {
                if (s.charAt(j) != sub.charAt(j - i)) {
                    if (!map.containsKey(sub.charAt(j - i))) {
                        matched = false;
                        break;
                    }
                    if (!map.get(sub.charAt(j - i)).contains(s.charAt(j))) {
                        matched = false;
                        break;
                    }
                }
            }
            if (matched) return true;
        }
        return false;
    }
}