import java.util.HashMap;

class NumKLenSubstrNoRepeats {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = -1;
        int res = 0;
        while (r + 1 < n) {
            r++;
            if (map.containsKey(s.charAt(r))) {
                int idx = map.get(s.charAt(r));
                while (l <= idx) {
                    map.remove(s.charAt(l));
                    l++;
                }
            }

            map.put(s.charAt(r), r);

            if (r - l + 1 == k) {
                res++;
                map.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
}