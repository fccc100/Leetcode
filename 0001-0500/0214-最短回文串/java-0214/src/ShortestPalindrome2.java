public class ShortestPalindrome2 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder(s);
        String revs = sb.reverse().toString();
        String temps = s + "#" + revs;
        int[] lps = getLps(temps);
        int l = lps[temps.length() - 1];
        return revs.substring(0, n - l) + s;
    }

    private int[] getLps(String s) {
        int n = s.length();

        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            // 前一位的最长前后缀
            int a = lps[i - 1];

            while (a > 0 && s.charAt(i) != s.charAt(a)) {
                a = lps[a - 1];
            }
            if (s.charAt(a) == s.charAt(i)) {
                lps[i] = a + 1;
            }
        }
        return lps;
    }
}
