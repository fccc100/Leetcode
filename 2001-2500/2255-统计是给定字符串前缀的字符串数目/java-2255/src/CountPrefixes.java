class CountPrefixes {
    public int countPrefixes(String[] words, String s) {
        int n = words.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.indexOf(words[i]) == 0) res++;
        }
        return res;
    }
}