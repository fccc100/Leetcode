import java.util.HashSet;

class LongestBeautifulSubstring {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();

        int res = 0;
        for (int i = 0; i < n; ) {
            if (word.charAt(i) != 'a') {
                i++;
                continue;
            }

            HashSet<Character> set = new HashSet<>();
            char cur = word.charAt(i);
            set.add(cur);
            int j = i + 1;
            while (j < n && word.charAt(j) - cur >= 0) {
                cur = word.charAt(j);
                set.add(cur);
                j++;
            }
            if (set.size() == 5) {
                res = Math.max(res, j - i);
            }
            i = j;
        }
        return res;
    }
}