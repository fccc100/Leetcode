import java.util.HashMap;
import java.util.Map;

class MakeSmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();

        Map<Integer, Character> map = new HashMap();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (s.charAt(l) < s.charAt(r)) {
                    map.put(r, s.charAt(l));
                } else {
                    map.put(l, s.charAt(r));
                }
                l++;
                r--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                res.append(s.charAt(i));
            } else {
                res.append(map.get(i));
            }
        }
        return res.toString();
    }
}