import java.util.HashSet;
import java.util.Set;

public class HasAllCodes2 {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (k > n) return false;
        int cur = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == '0') {
                cur *= 2;
            } else {
                cur *= 2;
                cur += 1;
            }
        }
        set.add(cur);
        int l = 0, r = k - 1;
        while (r < n) {
            cur <<= 1;
            if (s.charAt(l) == '1') {
                cur &= ~(1 << k);
            }
            l++;
            r++;
            if (r >= n) break;
            if (s.charAt(r) == '1') {
                cur += 1;
            }

            set.add(cur);
        }

        int cnt = (int) Math.pow(2, k);
        return set.size() == cnt;
    }
}
// s = "00110110", k = 2
// 10 -> 100 -> 1000
