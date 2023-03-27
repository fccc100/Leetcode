import java.util.HashMap;
import java.util.Map;

class CountSubstrings {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int res = 0;
        for (int i = 1; i <= Math.min(m, n); i++) {
            // 长度为i的字串
            for (int j = 0; j <= m - i; j++) {
                for (int k = 0; k <= n - i; k++) {
                    if (check(s, j, t, k, i)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    private boolean check(String s, int j, String t, int k, int len) {
        int res = 0;
        while (len > 0) {
            if (s.charAt(j) != t.charAt(k)) {
                res++;
            }
            j++;
            k++;
            len--;
        }
        return res == 1;
    }
}