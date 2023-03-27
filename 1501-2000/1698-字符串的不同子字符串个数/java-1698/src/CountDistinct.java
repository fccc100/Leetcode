import java.util.HashSet;
import java.util.Set;

class CountDistinct {
    public int countDistinct(String s) {
        int n = s.length();
        Set<String> set = new HashSet<String>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                set.add(s.substring(j, j + i));
            }
        }
        return set.size();
    }
}