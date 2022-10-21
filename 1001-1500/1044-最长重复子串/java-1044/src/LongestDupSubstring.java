import java.util.HashMap;
import java.util.Map;

class LongestDupSubstring {
    // TLE
    public String longestDupSubstring(String s) {
        int n = s.length();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = i; j < n; j++) {
                cur.append(s.charAt(j));

                map.put(cur.toString(), map.getOrDefault(cur.toString(), 0) + 1);
            }
        }

        String res = "";
        for (Map.Entry entry: map.entrySet()) {
            if ((int)entry.getValue() > 1) {
                if (entry.getKey().toString().length() > res.length()) {
                    res = entry.getKey().toString();
                }
            }
        }
        return res;
    }
}