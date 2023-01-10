class IsItPossible {
    public boolean isItPossible(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] map1 = new int[26];
        for (int i = 0; i < m; i++) {
            map1[word1.charAt(i) - 'a']++;
        }
        int[] map2 = new int[26];
        for (int i = 0; i < n; i++) {
            map2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < map1.length; i++) {
            if (map1[i] <= 0) continue;
            for (int j = 0; j < map2.length; j++) {
                if (map2[j] <= 0) continue;

                map1[i]--;
                map1[j]++;
                map2[j]--;
                map2[i]++;
                if (check(map1, map2)) {
                    return true;
                }
                map1[i]++;
                map1[j]--;
                map2[j]++;
                map2[i]--;
            }
        }
        return false;
    }
    private boolean check(int[] m1, int[] m2) {
        int c1 = 0, c2 = 0;
        for (int i = 0; i < m1.length; i++) {
            if (m1[i] > 0) c1++;
            if (m2[i] > 0) c2++;
        }
        return c1 == c2;
    }
}