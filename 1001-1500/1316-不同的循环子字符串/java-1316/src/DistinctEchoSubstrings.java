import java.util.HashSet;
import java.util.Set;

class DistinctEchoSubstrings {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> set = new HashSet<String>();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j <= n - (i * 2); j++) {
                String s1 = text.substring(j, j + i);
                String s2 = text.substring(j + i, j + 2 * i);
                if (s1.equals(s2)) {
                    set.add(s1);
                }
            }
        }
        return set.size();
    }
}