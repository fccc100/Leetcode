class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 != l2) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < l1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}