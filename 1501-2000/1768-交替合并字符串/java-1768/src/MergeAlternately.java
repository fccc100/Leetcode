class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        int cur = 1;
        while (i < m || j < n) {
            if (i >= m) {
                res.append(word2.charAt(j));
                j++;
                continue;
            }
            if (j >= n) {
                res.append(word1.charAt(i));
                i++;
                continue;
            }
            if (cur == 1) {
                res.append(word1.charAt(i));
                i++;
                cur = 2;
            } else {
                res.append(word2.charAt(j));
                j++;
                cur = 1;
            }
        }
        return res.toString();
    }
}