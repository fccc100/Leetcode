class NumMatchingSubseq {

    // TLE
    public int numMatchingSubseq(String s, String[] words) {
        int n = words.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isSubseq(s, words[i])) {
                res++;
            }
        }
        return res;
    }

    private boolean isSubseq(String s, String sub) {
        int i = 0, j = 0;
        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j >= sub.length();
    }
}