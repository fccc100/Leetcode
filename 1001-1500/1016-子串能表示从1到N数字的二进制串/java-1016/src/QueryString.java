import java.util.HashSet;

class QueryString {
    public boolean queryString(String s, int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') continue;
            int cur = 1;
            set.add(cur);
            for (int j = i + 1; j < Math.min(i + 31, s.length()); j++) {
                if (s.charAt(j) == '0') {
                    cur = cur * 2;
                } else {
                    cur = cur * 2 + 1;
                }
                if (cur <= n) {
                    set.add(cur);
                }
            }
        }

        return set.size() == n;
    }
}