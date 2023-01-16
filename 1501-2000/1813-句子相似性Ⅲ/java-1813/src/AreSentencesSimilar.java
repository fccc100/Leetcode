class AreSentencesSimilar {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] strs1 = sentence1.split(" ");
        String[] strs2 = sentence2.split(" ");
        int m = strs1.length;
        int n = strs2.length;

        int i = 0;
        int j = 0;
        while (i < m && j < n && strs1[i].equals(strs2[j])) {
            i++;
            j++;
        }

        int i1 = m - 1;
        int j1 = n - 1;
        while (i1 >= 0 && j1 >= 0 && strs1[i1].equals(strs2[j1])) {
            i1--;
            j1--;
        }
        if (i > i1 || j > j1) {
            return true;
        }
        return false;
    }
}